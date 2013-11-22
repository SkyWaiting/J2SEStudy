package com.packtpub.java7.concurrency.chapter1.recipe4;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-11-21
 * Time: 6:23
 *
 */
public class Main {

    public static void main(String[] args) {
        //Creates the Runnable object and the Thread to run it
        FileSearch searcher = new FileSearch("", "");
        Thread thread = new Thread(searcher);

        //Starts the Thread
        thread.start();

        //Wait for ten seconds
        try {
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //Interrupts the thread
        thread.interrupt();
    }
}
