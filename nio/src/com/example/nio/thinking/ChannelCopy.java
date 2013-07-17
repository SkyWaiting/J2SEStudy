package com.example.nio.thinking;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Copying a file using channels and buffers
 * 
 * {Args: ChannelCopy.java test.txt}
 * @author guorui
 *
 */
public class ChannelCopy {

	private static final int BSIZE = 1024;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		if(args.length != 2){
			System.out.println("arguments:sourcefile destfile");
			System.exit(1);
		}
		FileChannel in = new FileInputStream(args[0]).getChannel();
		FileChannel out = new FileOutputStream(args[1]).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while(in.read(buffer)!=-1){
			buffer.flip();
			out.write(buffer);
			buffer.clear();
		}
	}

}
