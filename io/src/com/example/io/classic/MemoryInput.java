package com.example.io.classic;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		StringReader in = new StringReader(BufferedInputFile.read(System
				.getProperty("user.dir")
				+ File.separator
				+ "src\\io\\classic\\MemoryInput.java"));
        int c;
        while((c=in.read())!=-1){
        	System.out.print((char)c);
        }
		
	}

}
