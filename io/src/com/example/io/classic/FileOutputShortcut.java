package com.example.io.classic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {

	static String file = "FileOutputShortcut.out";
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new StringReader(
				BufferedInputFile.read(System.getProperty("user.dir")
						+ File.separator
						+ "src\\io\\classic\\FileOutputShortcut.java")));
		//here's the shortcut
		PrintWriter out = new PrintWriter(file);
		int lineCount = 1;
		String s;
		while((s = in.readLine())!=null){
			out.println(lineCount++ +": "+s);
		}
		out.close();
		//show the stored file:
		System.out.println(BufferedInputFile.read(file));
	}

}
