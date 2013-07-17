package com.example.nio.sonsoft.channels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Specialization of the SelectSockets class which uses a thread pool to service
 * channels.The thread pool is an ad-hoc implementation quickly lashed together
 * in a few hours for damonstration purposes.It's definitely not production
 * quality.
 * 
 * @author guorui
 *
 */
public class SelectSocketsThreadPool extends SelectSockets {

	private static final int MAX_THREADS = 5;
	private ThreadPool pool = new ThreadPool(MAX_THREADS);
	
	public static void main(String[] args) throws Exception {
		new SelectSocketsThreadPool().go(args);
	}
	
	protected void readDataFromSocket(SelectionKey key) throws Exception{
		WorkerThread worker = pool.getWorker();
		if(worker == null){
			//No threads available.DO nothing.The selection
			//loop will keep calling this method until a thread
			//becomes available.This design could be improved.
			return;
		}
		worker.serviceChannel(key);
	}
	
	/**
	 * 
	 * A very simple thread pool class.The pool size is set at construction
	 * time and remains fixed.Threads are cycled through a FIFO idle queue.
	 * 
	 * @author guorui
	 *
	 */
	private class ThreadPool{
		List<WorkerThread> idle = new LinkedList<WorkerThread>();
		ThreadPool(int poolSize){
			//Fill up the pool with worker threads
			for(int i=0;i<poolSize;i++){
				WorkerThread thread = new WorkerThread(this);
				//Set thread name for debugging.Start it.
				thread.setName("Worker-"+(i+1)+"Thread");
				thread.start();
				idle.add(thread);
			}
		}
		
		/**
		 * 
		 * Find an idle worker thread,if any.Could return null.
		 * 
		 * @return
		 */
		WorkerThread getWorker(){
			WorkerThread worker = null;
			
			synchronized(idle){
				if(idle.size()>0){
					worker = idle.remove(0);
				}
			}
			return worker;
		}
		
		/**
		 * 
		 * Called by the worker thread to return itself to the idle pool
		 * 
		 * @param worker
		 */
		void returnWorker(WorkerThread worker){
			synchronized(idle){
				idle.add(worker);
			}
		}
		
	}
	
	/**
	 * 
	 * A worker thread class which can drain channels and echo-back the input.
	 * Each instance is constructed with a reference to the owning thread pool
	 * object.When started,the thread loops forever waiting to be awakened to
	 * service the channel associated with a SelectionKey object.The worker is
	 * tasked by calling its serviceChannel() method with a SelectiongKey object.
	 * The serviceChannel() method stores the key reference in the thread object
	 * then calls notify() to wake it up.When the channel has been drained,the
	 * worker thread returns itself to its parent pool.
	 * 
	 * @author guorui
	 *
	 */
	private class WorkerThread extends Thread{
		private ByteBuffer buffer = ByteBuffer.allocate(1024);
		private ThreadPool pool;
		private SelectionKey key;
		
		WorkerThread(ThreadPool pool){
			this.pool = pool;
		}
		
		//Loop forever waiting for work to do
		public synchronized void run(){
			System.out.println(this.getName()+"is ready");
			while(true){
				try{
					//Sleep and release object lock
					this.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
					//Clear interrupt status
					this.interrupted();
				}
				if(key == null){
					continue; //just in case
				}
				System.out.println(this.getName() + " has been awakened");
				try{
					drainChannel(key);
				}catch(Exception e){
					System.out.println("Caught '"+e+"' closing channel");
					//Close channel and nudge selector
					try{
						key.channel().close();
					}catch(IOException ex){
						ex.printStackTrace();
					}
					key.selector().wakeup();
				}
				key = null;
				
				//Done.Ready for more. Return to pool
				this.pool.returnWorker(this);
			}
		}
		
		/**
		 * Called to initiate a unit of work by this worker thread on the provided
		 * SelectionKey object.This method is synchronized,as is the run() method,
		 * so only one key can be serviced at a given time.Before waking the worker
		 * thread,and before returning to the main selection loop,this key's interest
		 * set is updated to remove OP_READ. This will cause the selector to ignore
		 * read-readiness for this channel while the worker thread is servicing it.
		 * 
		 * @param key
		 */
		synchronized void serviceChannel(SelectionKey key){
			this.key = key;
			
			key.interestOps(key.interestOps() & ~SelectionKey.OP_READ);
			
			this.notify();//Awaken the thread
		}
		
		/**
		 * 
		 * @param key
		 * @throws Exception
		 */
		void drainChannel(SelectionKey key) throws Exception{
			SocketChannel channel = (SocketChannel)key.channel();
			int count;
			buffer.clear();//Empty buffer
			ByteBuffer newByteBuffer = ByteBuffer.allocateDirect(1024);
			
			//Loop while data is available;channel is nonblocking
			while((count = channel.read(buffer))>0){
				buffer.flip();//Make buffer readable
				newByteBuffer.put("\r\n".getBytes());
				newByteBuffer.put("==>".getBytes());
				newByteBuffer.put(buffer);
				newByteBuffer.put("\r\n".getBytes());
				newByteBuffer.flip();
				//Send the data;may not go all at once
				while(newByteBuffer.hasRemaining()){
					channel.write(newByteBuffer);
				}
				
				//WARNING:the above loop is evil.
				//See comments in superclass.
				newByteBuffer.clear();
				buffer.clear();
			}
			if(count<0){
				//Close channel on EOF;invalidates the key
				channel.close();
				return;
			}
			
			//Resume interest in OP_READ
			key.interestOps(key.interestOps() | SelectionKey.OP_READ);
			//Cycle the selector so this key is active again
			key.selector().wakeup();
		}
		
	}
}
