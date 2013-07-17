package com.example.nio.thinking;

import java.nio.*;

import static com.example.io.util.Print.print;
import static com.example.io.util.Print.printnb;

/**
 * Created by IntelliJ IDEA.
 * User: guorui
 * Date: 13-2-28
 * Time: 上午8:57
 * To change this template use File | Settings | File Templates.
 */
public class ViewBuffers {
    /**
     * @param args
     */
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,97});
        bb.rewind();
        printnb("Byte Buffer ");
        while(bb.hasRemaining())
            printnb(bb.position()+" -> "+bb.get()+", ");
        print();
        CharBuffer cb = ((ByteBuffer)bb.rewind()).asCharBuffer();
        printnb("Char Buffer ");
        while(cb.hasRemaining())
            printnb(cb.position()+" -> "+cb.get()+", ");
        print();
        FloatBuffer fb = ((ByteBuffer)bb.rewind()).asFloatBuffer();
        printnb("Float Buffer ");
        while(fb.hasRemaining())
            printnb(fb.position()+" -> "+fb.get()+", ");
        print();
        IntBuffer ib = ((ByteBuffer)bb.rewind()).asIntBuffer();
        printnb("Int Buffer ");
        while(ib.hasRemaining())
            printnb(ib.position()+" -> "+ib.get()+", ");
        print();
        LongBuffer lb = ((ByteBuffer)bb.rewind()).asLongBuffer();
        printnb("Long Buffer ");
        while(lb.hasRemaining())
            printnb(lb.position()+" -> "+lb.get()+", ");
        print();
        ShortBuffer sb = ((ByteBuffer)bb.rewind()).asShortBuffer();
        printnb("Short Buffer ");
        while(sb.hasRemaining())
            printnb(sb.position()+" -> "+sb.get()+", ");
        print();
        DoubleBuffer db = ((ByteBuffer)bb.rewind()).asDoubleBuffer();
        printnb("Double Buffer ");
        while(db.hasRemaining())
            printnb(db.position()+" -> "+db.get()+", ");
    }
}
