package com.packtpub.java7.concurrency.chapter1.recipe12;

/**
 * Created by guorui on 14-4-24.
 */
public class Main {
    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");

        Task task = new Task();
        Thread thread;

        System.out.printf("Starting the Threads\n");
        for (int i = 0; i < 10; i++){
            thread = factory.newThread(task);
            thread.start();
        }

        System.out.printf("Factory stats:\n");
        System.out.printf("%s\n",factory.getStats());
    }
}
