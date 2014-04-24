package com.packtpub.java7.concurrency.chapter1.recipe12;

import java.util.concurrent.TimeUnit;

/**
 * Created by guorui on 14-4-24.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
