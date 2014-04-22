package com.packtpub.java7.concurrency.chapter1.recipe9;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by guorui on 14-4-22.
 */
public class UnsafeTask implements Runnable{

    /**
     *  Date shared by all threads
     */
    private Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread: %s : %s\n",Thread.currentThread().getId(),startDate);
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(),startDate);
    }
}
