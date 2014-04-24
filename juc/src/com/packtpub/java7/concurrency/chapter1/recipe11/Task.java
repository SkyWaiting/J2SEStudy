package com.packtpub.java7.concurrency.chapter1.recipe11;

import java.util.Random;

/**
 * Created by guorui on 14-4-23.
 */
public class Task implements Runnable {

    @Override
    public void run() {
        int result;
        // Create a random number generator
        Random random = new Random(Thread.currentThread().getId());
        while (true){
            // Generate a random number a calculate 1000 divide by that random number
            System.out.printf("Thread %s dividend is %d\n",Thread.currentThread().getId(),(int)(random.nextDouble()*1000));
            result = 1000/((int)(random.nextDouble()*1000));
            System.out.printf("%s : %d\n",Thread.currentThread().getId(),result);
            // Check if the Thread has been interrupted
            if (Thread.currentThread().isInterrupted()){
                System.out.printf("%d : Interrupted\n",Thread.currentThread().getId());
                return;
            }
        }
    }
}
