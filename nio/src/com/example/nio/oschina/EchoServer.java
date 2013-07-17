package com.example.nio.oschina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-3-7
 * Time: 下午12:13
 * To change this template use File | Settings | File Templates.
 */
public class EchoServer {

    public static SelectorLoop connectionBell;
    public static SelectorLoop readBell;
    public boolean isReadBellRunning = false;

    public static void main(String[] args) throws IOException{
        new EchoServer().startServer();
    }

    //启动服务器
    public void startServer() throws IOException{
        //准备好一个闹钟，当有连接进来的时候响
        connectionBell = new SelectorLoop();
        //准备好一个闹钟，当有read事件进来的时候响
        readBell = new SelectorLoop();

        //开启一个server channel 来监听
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //开启非阻塞模式
        ssc.configureBlocking(false);

        ServerSocket socket = ssc.socket();
        socket.bind(new InetSocketAddress("localhost",7878));

        //给闹钟规定好要监听的事件，这个闹钟只监听新连接事件
        ssc.register(connectionBell.getSelector(),SelectionKey.OP_ACCEPT);
        new Thread(connectionBell).start();
    }


    public class SelectorLoop implements Runnable {

        private Selector selector;

        private ByteBuffer buffer = ByteBuffer.allocate(1024);

        public SelectorLoop() throws IOException {
            this.selector = Selector.open();
        }

        public Selector getSelector() {
            return this.selector;
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
            while (true) {
                try {
                    //阻塞，只有当至少一个注册事件发生时才会继续
                    this.selector.select();

                    Set<SelectionKey> selectKeys = this.selector.selectedKeys();
                    Iterator<SelectionKey> it = selectKeys.iterator();
                    while (it.hasNext()) {
                        SelectionKey key = it.next();
                        it.remove();
                        //处理事件，可以用多线程来处理
                        this.dispatch(key);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        public void dispatch(SelectionKey key) throws IOException, InterruptedException {
            if (key.isAcceptable()) {
                //这是一个connection accept事件，并且这个事件是注册在ServerSocketChannel上的
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                //接受一个连接
                SocketChannel sc = ssc.accept();

                sc.configureBlocking(false);
                sc.register(readBell.getSelector(), SelectionKey.OP_READ);

                //如果读线程还没有启动，那就启动一个读线程。
                synchronized (EchoServer.this) {
                    if (!EchoServer.this.isReadBellRunning) {
                        EchoServer.this.isReadBellRunning = true;
                        new Thread(readBell).start();
                    }
                }
            } else if (key.isReadable()) {
                //这是一个read事件，并且这个事件是注册在SocketChannel上的
                SocketChannel sc = (SocketChannel)key.channel();
                //写数据到buffer
                int count = sc.read(buffer);
                if(count < 0){
                    //客户端已经断开连接
                    key.cancel();
                    sc.close();
                    return;
                }
                //切换buffer到读状态，内部指针归位
                buffer.flip();
                String msg = Charset.forName("UTF-8").decode(buffer).toString();
                System.out.println("Server received [" + msg +"] from client address: " + sc.socket().getRemoteSocketAddress());
                Thread.sleep(1000);
                //echo back
                sc.write(ByteBuffer.wrap(msg.getBytes(Charset.forName("UTF-8"))));

                //清空buffer
                buffer.clear();
            }
        }
    }
}
