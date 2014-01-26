package com.packtpub.java7.concurrency.chapter1.recipe8;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 14-1-26
 * Time: 下午5:06
 */
public class Main {
    public static void main(String[] args) {
        //Create the Task
        Task task = new Task();
        //Creates the Thread
        Thread thread = new Thread(task);
        //Sets the uncaught exception handler
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        //Start the Thread
        thread.start();
        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.printf("Thread has finished\n");
    }
}
