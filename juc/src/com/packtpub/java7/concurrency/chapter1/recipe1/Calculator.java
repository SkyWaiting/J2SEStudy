package com.packtpub.java7.concurrency.chapter1.recipe1;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-11-16
 * Time: 上午9:00
 *
 */
public class Calculator  implements Runnable{

    private int number;

    public Calculator(int number){
        this.number = number;
    }
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
        for (int i=1; i<=10; i++){
            System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
        }
    }


}
