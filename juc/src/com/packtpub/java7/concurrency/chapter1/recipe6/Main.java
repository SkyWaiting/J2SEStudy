package com.packtpub.java7.concurrency.chapter1.recipe6;

import java.util.Date;

/**
 * User: guorui
 * Date: 13-11-26
 * Time: 5:27
 */
public class Main {

    public static void main(String[] args) {

        // Creates and starts a DataSourcesLoader runnable object.
        DataSourcesLoader dsLoader = new DataSourcesLoader();
        Thread thread1 = new Thread(dsLoader,"DataSourceThread");
        thread1.start();

        // Creates and starts a NetworkConnectionsLoader runnable object.
        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread thread2 = new Thread(ncLoader,"NetworkConnectionThread");
        thread2.start();

        // Wait for the finalization of the two threads
        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        // Write a message
        System.out.printf("Main: Configuration has been loaded: %s\n",new Date());

    }

}
