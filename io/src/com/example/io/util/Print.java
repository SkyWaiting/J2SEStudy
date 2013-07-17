package com.example.io.util;

import java.io.PrintStream;

/**
 * Created by IntelliJ IDEA.
 * User: guorui
 * Date: 13-2-28
 * Time: 上午8:46
 * To change this template use File | Settings | File Templates.
 */
public class Print {

    //Print with a newline:
    public static void print(Object obj){
        System.out.println(obj);
    }

    //Print a newline by itself:
    public static void print(){
        System.out.println();
    }

    //Print with no line blank:
    public static void printnb(Object obj){
        System.out.print(obj);
    }

    //The new Java SE5 printf() (from C)
    public static PrintStream printf(String format,Object... args){
        return System.out.printf(format,args);
    }
}
