package com.packtpub.java7.concurrency.chapter1.recipe6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: guorui
 * Date: 13-11-26
 * Time: 5:25
 */
public class NetworkConnectionsLoader implements Runnable{

    @Override
    public void run() {
        //Write a message
        System.out.printf("Begining network connections loading: %s\n",new Date());
        //Sleep four seconds
        try {
            TimeUnit.SECONDS.sleep(6);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //Write a message
        System.out.printf("Network connections loading has finished: %s\n",new Date());
    }
}
