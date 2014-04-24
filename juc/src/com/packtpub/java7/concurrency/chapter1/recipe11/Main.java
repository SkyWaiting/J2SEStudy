package com.packtpub.java7.concurrency.chapter1.recipe11;

/**
 * Created by guorui on 14-4-23.
 */
public class Main {
    public static void main(String[] args) {
        /*MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        Task task = new Task();
        for (int i=0; i<1; i++){
            Thread t = new Thread(threadGroup,task);
            t.start();
        }*/
        Task task = new Task();
        Thread t = new Thread(task);
        t.start();
        /*int result = 1000/491;
        System.out.printf("result is %d",result);*/
    }
}
