package com.packtpub.java7.concurrency.chapter1.recipe6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * User: guorui
 * Date: 13-11-26
 * Time: 5:02
 *
 */
public class DataSourcesLoader implements Runnable{

    @Override
    public void run() {
        //Write a message
        System.out.printf("Begining data sources loading: %s\n",new Date());
        //Sleep four seconds
        try {
            TimeUnit.SECONDS.sleep(4);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //Write a message
        System.out.printf("Data sources loading has finished: %s\n",new Date());
    }
}
