package com.packtpub.java7.concurrency.chapter1.recipe1;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-11-16
 * Time: 上午9:31
 *
 */
public class Main {
    public static void main(String[] args) {
        for (int i=1; i<=10; i++){
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}
