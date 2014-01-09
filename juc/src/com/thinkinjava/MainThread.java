package com.thinkinjava;

/**
 * 由main线程驱动任务
 * User: guorui
 * Date: 14-1-4
 * Time: 上午9:28
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }

}
