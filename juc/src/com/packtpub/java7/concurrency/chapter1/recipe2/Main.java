package com.packtpub.java7.concurrency.chapter1.recipe2;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-11-16
 * Time: 上午10:03
 *
 */
public class Main {
    public static void main(String[] args) {

        //Thread priority information
        System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);

        Thread threads[] = new Thread[10];
        Thread.State status[] = new Thread.State[10];
        for (int i=0; i<10; i++){
            threads[i] = new Thread(new Calculator(i));
            if ((i%2) ==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread "+i);
        }


    }
}
