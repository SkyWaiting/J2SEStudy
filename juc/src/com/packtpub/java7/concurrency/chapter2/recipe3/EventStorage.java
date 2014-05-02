package com.packtpub.java7.concurrency.chapter2.recipe3;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 2014/4/28
 * Time: 17:15
 */
public class EventStorage {

    private int maxSize;
    private List<Date> storage;

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<>();
    }

    public synchronized void set(){
        while (storage.size() == maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            storage.add(new Date());

        }
    }
}
