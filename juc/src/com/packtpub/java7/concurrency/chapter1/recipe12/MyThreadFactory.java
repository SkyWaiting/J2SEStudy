package com.packtpub.java7.concurrency.chapter1.recipe12;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by guorui on 14-4-24.
 */
public class MyThreadFactory implements ThreadFactory {

    // Attributes to save the necessary data to the factory
    private int counter;
    private String name;
    private List<String> stats;

    public MyThreadFactory(String name) {
        this.counter = 0;
        this.name = name;
        this.stats = new ArrayList<String>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,name + "_Thread_" + counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s\n",t.getId(),t.getName(),new Date()));
        return t;
    }

    public String getStats(){
        StringBuffer sBuffer = new StringBuffer();
        Iterator<String> it = stats.iterator();

        while (it.hasNext()){
            sBuffer.append(it.next());
        }

        return sBuffer.toString();
    }
}
