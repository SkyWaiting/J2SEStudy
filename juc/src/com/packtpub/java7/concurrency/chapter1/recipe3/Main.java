package com.packtpub.java7.concurrency.chapter1.recipe3;

import java.util.concurrent.TimeUnit;

/**
 * Launch the PrimeGenerator, waits five seconds and interrupts the Thread
 * User: guorui
 * Date: 13-11-20
 * Time: 下午4:21
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //Launch the prime numbers generator
        Thread task = new PrimeGenerator();
        task.start();
        //Wait 5 seconds
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //Interrupt the prime number generator
        task.interrupt();
    }

}
