package com.example.nio.thinking;

import java.nio.ByteBuffer;

import static com.example.io.util.Print.print;
import static com.example.io.util.Print.printnb;

/**
 * Getting different representations from a ByteBuffer
 * 
 * @author guorui
 *
 */
public class GetData {

	private static final int BSIZE = 1024;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		//Allocation automatically zeroes the ByteBuffer
		int i=0;
		while(i++<bb.limit()){
			if(bb.get()!=0)
				print("nonzero");
		}
		print("i = "+i);
		//Rewinds the Buffer.The position is set to zero and the mark is discarded
		bb.rewind();
		//Store and read a char array
		bb.asCharBuffer().put("Howdy!");
		char c;
		while((c = bb.getChar())!=0)
			printnb(c + " ");
		print();
		bb.rewind();
		//Store and read a short:
		bb.asShortBuffer().put((short)471142);
		print(bb.getShort());
		bb.rewind();
		//Store and read an int:
		bb.asIntBuffer().put(99471142);
		print(bb.getInt());
		bb.rewind();
		//Store and read an long:
		bb.asLongBuffer().put(99471142);
		print(bb.getLong());
		bb.rewind();
		//Store and read a float:
		bb.asFloatBuffer().put(99471142);
		print(bb.getFloat());
		bb.rewind();
		//Store and read a double:
		bb.asDoubleBuffer().put(99471142);
		print(bb.getDouble());
		bb.rewind();
	}

}
