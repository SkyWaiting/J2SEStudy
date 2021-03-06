package com.packtpub.java7.concurrency.chapter1.recipe9;

import java.util.concurrent.TimeUnit;

/**
 * Created by guorui on 14-4-22.
 */
public class SafeMain {

    public static void main(String[] args) {
        SafeTask task = new SafeTask();
        for (int i=0;i<3;i++){
            Thread thread = new Thread(task);
            thread.start();
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
