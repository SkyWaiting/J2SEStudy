package com.example.nio.thinking;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Converting text to and from ByteBuffers
 * 
 * @author guorui
 *
 */
public class BufferToText {
	
	private static final int BSIZE = 1024;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		FileChannel fc = new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		fc = new FileInputStream("data2.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		//Doesn't work:
		System.out.println(buff.asCharBuffer());
		//Decode using this system's default Charset:
		//Rewinds the Buffer.The position is set to zero and the mark is discarded
		buff.rewind();
		String encoding = System.getProperty("file.encoding");
		System.out.println("Decoded using "+encoding+": " + Charset.forName(encoding).decode(buff));
		//Or,we could encode with something that will pring:
		fc = new FileOutputStream("data3.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
		fc.close();
		//Now try reading again:
		fc = new FileInputStream("data3.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		//Use a CharBuffer to write through:
		fc = new FileOutputStream("data4.txt").getChannel();
		buff = ByteBuffer.allocate(24);//More than needed
		buff.asCharBuffer().put("Some text");
		fc.write(buff);
		fc.close();
		//Read and display:
		fc = new FileInputStream("data4.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
	}

}
