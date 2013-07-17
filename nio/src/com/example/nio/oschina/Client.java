package com.example.nio.oschina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-7
 * Time: 下午3:22
 * To change this template use File | Settings | File Templates.
 */
public class Client implements Runnable{

    //空闲计数器，如果空闲超过10次，将检测server是否中断连接
    private static int idleCounter = 0;
    private Selector selecor;
    private SocketChannel socketChannel;
    private ByteBuffer buffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) throws IOException{
        Client client = new Client();
        new Thread(client).start();
    }

    public Client() throws IOException{
        //同样的，注册闹钟
        this.selecor = Selector.open();

        //连接远程server
        socketChannel = SocketChannel.open();
        //如果快速的建立了连接，返回true.如果没有建立，则返回false，并在连接后发出connect事件
        Boolean isConnected = socketChannel.connect(new InetSocketAddress("localhost",7878));
        socketChannel.configureBlocking(false);
        SelectionKey key = socketChannel.register(selecor,SelectionKey.OP_READ);

        if (isConnected){
            this.sendFirstMsg();
        }else{
            //如果连接还在尝试中，则注册connect事件的监听.connect成功后会发出connect事件。
            key.interestOps(SelectionKey.OP_CONNECT);
        }
    }

    public void sendFirstMsg() throws IOException{
        String msg = "Hello NIO.";
        socketChannel.write(ByteBuffer.wrap(msg.getBytes(Charset.forName("UTF-8"))));
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true){

            try {
                //阻塞，等待事件发生，或者1秒超时，num为发生事件的数量
                int num = this.selecor.select(1000);
                if (num == 0){
                    idleCounter ++;
                    if (idleCounter > 10){
                        //如果server断开了连接，发送消息将失败.
                        try {
                            this.sendFirstMsg();
                        } catch (ClosedChannelException e) {
                            e.printStackTrace();
                            this.socketChannel.close();
                            return;
                        }
                    }
                    continue;
                }else {
                    idleCounter = 0;
                }
                Set<SelectionKey> keys = this.selecor.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while(it.hasNext()){
                    SelectionKey key = it.next();
                    it.remove();
                    if(key.isConnectable()){
                        //socket connected
                        SocketChannel sc = (SocketChannel)key.channel();
                        if(sc.isConnectionPending()){
                            sc.finishConnect();
                        }
                        //send first message
                        this.sendFirstMsg();
                    }
                    if (key.isReadable()){
                        //msg received
                        SocketChannel sc = (SocketChannel)key.channel();
                        this.buffer = ByteBuffer.allocate(1024);
                        int count = sc.read(buffer);
                        if (count < 0){
                            sc.close();
                            continue;
                        }
                        //切换到buffer读状态，内部指针归位.
                        buffer.flip();
                        String msg = Charset.forName("UTF-8").decode(buffer).toString();
                        System.out.println("Client received [" + msg + "] from server address:" + sc.socket().getRemoteSocketAddress());

                        Thread.sleep(1000);
                        //echo back
                        sc.write(ByteBuffer.wrap(msg.getBytes(Charset.forName("UTF-8"))));

                        //清空buffer
                        buffer.clear();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
