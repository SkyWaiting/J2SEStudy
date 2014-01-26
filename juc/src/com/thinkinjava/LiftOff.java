package com.thinkinjava;

/**
 * 定义一个任务，实现Runnable接口的run()方法
 * User: guorui
 * Date: 14-1-4
 * Time: 上午9:22
 */
public class LiftOff implements Runnable{

    protected int countDown = 10; //Default
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#" + id + "(" +(countDown > 0 ? countDown : "LiftOff!") + "),";
    }

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.print(status());
            Thread.yield();
        }
    }
}
