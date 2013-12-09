package com.packtpub.java7.concurrency.chapter1.recipe7;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * User: guorui
 * Date: 13-12-6
 * Time: 17:33
 */
public class Main {

    public static void main(String[] args) {

        //Creates the Event data structure
        Deque<Event> deque = new ArrayDeque<>();

        //Creates the three WriterTask and starts them
        WriterTask writer = new WriterTask(deque);
        for (int i=0; i<3; i++){
            Thread thread = new Thread(writer);
            thread.start();
        }

        //Creates a cleaner task and starts it
        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
    }
}
