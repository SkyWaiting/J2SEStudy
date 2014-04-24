package com.packtpub.java7.concurrency.chapter1.recipe11;

/**
 * Created by guorui on 14-4-23.
 */
public class MyThreadGroup extends ThreadGroup {

    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        // Prints the name of the Thread
        System.out.printf("The thread %s has thrown an Exception\n",t.getId());
        // Print the stack trace of the exception
        e.printStackTrace(System.out);
        // Interrupt the rest of the threads of the thread group
        System.out.printf("Terminating the rest of the Threads\n");
        interrupt();
    }
}
