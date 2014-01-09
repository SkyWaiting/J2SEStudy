package com.packtpub.java7.concurrency.chapter1.recipe5;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Class that writes the actual date to a file every second.
 * User: guorui
 * Date: 13-11-25
 * Time: 下午3:18
 */
public class FileClock implements Runnable{

    @Override
    public void run() {
            for (int i=0; i<10; i++){
            System.out.printf("%s\n",new Date());
            try {
                //Sleep during one second
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e){
                System.out.printf("The FileClock has been interrupted");
            }
        }
    }

}
