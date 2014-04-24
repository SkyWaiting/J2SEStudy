package com.packtpub.java7.concurrency.chapter1.recipe10;

import java.util.concurrent.TimeUnit;

/**
 * Created by guorui on 14-4-22.
 */
public class Main {

    public static void main(String[] args) {
        //Create a ThreadGroup
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();

        SearchTask searchTask = new SearchTask(result);
        for (int i=0; i<5; i++){
            Thread thread = new Thread(threadGroup,searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Write information about the ThreadGroup to the console
        System.out.printf("Number of Threads: %d\n",threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();

        // Write information about the status of the Thread objects to the console
        Thread[] threads = new Thread[threadGroup.activeCount()];
        //把此线程组及其子组中的所有活动线程复制到指定数组中
        threadGroup.enumerate(threads);
        for (int i=0; i<threadGroup.activeCount(); i++){
            System.out.printf("Thread %s: %s\n",threads[i].getName(),threads[i].getState());
        }

        // Wait for the finalization of the Threads
        waitFinish(threadGroup);
        // Interrupt all the Thread objects assigned to the ThreadGroup
        threadGroup.interrupt();
    }

    private static void waitFinish(ThreadGroup threadGroup){
        System.out.printf("waitFinish Method Number of Threads: %d\n",threadGroup.activeCount());
        while (threadGroup.activeCount() > 4){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
