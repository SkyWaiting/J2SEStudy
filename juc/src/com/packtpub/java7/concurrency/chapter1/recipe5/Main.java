package com.packtpub.java7.concurrency.chapter1.recipe5;

import java.util.concurrent.TimeUnit;

/**
 * User: guorui
 * Date: 13-11-26
 * Time: 上午10:35
 */
public class Main {
    public static void main(String[] args) {
        //Creates a FileClock runnable object and a Thread to run it.
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);

        //Starts the Thread
        thread.start();
        try{
            //Waits five seconds
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //Interrupts the Thread
        thread.interrupt();
    }
}
