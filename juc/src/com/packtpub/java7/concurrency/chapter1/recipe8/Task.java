package com.packtpub.java7.concurrency.chapter1.recipe8;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 14-1-26
 * Time: 下午5:05
 */
public class Task implements Runnable{
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        // The next instruction always throws and exception
        int numero=Integer.parseInt("TTT");
    }
}
