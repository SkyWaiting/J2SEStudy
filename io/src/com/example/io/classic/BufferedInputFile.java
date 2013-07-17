package com.example.io.classic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {

	//Throw exceptions to console
	public static String read(String filename) throws IOException{
		//Reading input by lines:
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s=in.readLine())!=null){
			sb.append(s+"\n");
		}
		in.close();
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println(System.getProperty("user.dir")+File.separator+"src\\io\\classic\\BufferedInputFile.java");
//		System.out.println(BufferedInputFile.class.getResource("").getPath()+"BufferedInputFile.java");
//		System.out.println(Thread.currentThread().getContextClassLoader().getResourceAsStream("BufferedInputFile.java"));
//		System.out.println(BufferedInputFile.class.getResourceAsStream("BufferedInputFile.java"));
//		System.out.println(BufferedInputFile.class.getClassLoader().getResourceAsStream("BufferedInputFile.java"));
		System.out.println(read(System.getProperty("user.dir")+File.separator+"src\\io\\classic\\BufferedInputFile.java"));
	}
}
