package com.thinkinjava;

/**
 * 使用Thread构造器驱动任务
 * User: guorui
 * Date: 14-1-4
 * Time: 上午9:31
 */
public class BasicThreads {

    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }

}
