package com.packtpub.java7.concurrency.chapter1.recipe9;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by guorui on 14-4-22.
 */
public class SafeTask implements Runnable {

    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
        protected Date initialValue(){
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n",Thread.currentThread().getId(),startDate.get());
        try{
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(),startDate.get());
    }
}
