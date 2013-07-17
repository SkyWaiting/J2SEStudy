package com.example.io.classic;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(new BufferedInputStream(
				new FileInputStream(System
						.getProperty("user.dir")
						+ File.separator
						+ "src\\io\\classic\\TestEOF.java")));
		while(in.available()!=0){
			System.out.print((char)in.readByte());
		}
	}

}
