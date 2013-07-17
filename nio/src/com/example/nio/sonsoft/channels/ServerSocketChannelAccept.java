package com.example.nio.sonsoft.channels;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 
 * Test nonblocking accept() using ServerSocketChannel.
 * Start this program,then "telnet localhost 1234" to
 * connect to it.
 * 
 * @author guorui
 *
 */
public class ServerSocketChannelAccept {

	public static final String GREETING = "Hello I must be going.\r\n";
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		int port = 1234;
		if(args.length>0){
			port = Integer.parseInt(args[0]);
		}
		
		ByteBuffer buffer = ByteBuffer.wrap(GREETING.getBytes());
		//打开ServerSocket通道
		ServerSocketChannel ssc = ServerSocketChannel.open();
		//绑定监听端口号
		ssc.socket().bind(new InetSocketAddress(port));
		//设置为非阻塞模式
		ssc.configureBlocking(false);
		while(true){
			System.out.println("Waiting for connections");
			SocketChannel sc = ssc.accept();
			if(sc==null){
				//no connections,snooze a while
				Thread.sleep(2000);
			}else{
				System.out.println("Incoming connection from:"+sc.socket().getRemoteSocketAddress());
				buffer.rewind();
				sc.write(buffer);
				sc.close();
			}
		}
		
	}

}
