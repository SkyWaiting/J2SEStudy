package com.thinkinjava;

/**
 * User: guorui
 * Date: 14-1-4
 * Time: 上午9:39
 */
public class MoreBasicThreads {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
