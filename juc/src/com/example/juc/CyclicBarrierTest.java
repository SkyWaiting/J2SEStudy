package com.example.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 当你在很多环节需要卡住，要多个线程同时在这里都达到后，
 * 再向下走，很有用途
 * User: guorui
 * Date: 13-7-18
 * Time: 上午9:36
 *
 */
public class CyclicBarrierTest {
    private static final int THREAD_COUNT = 10;

    private final static CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(THREAD_COUNT,
            new Runnable() {
                @Override
                public void run() {
                    System.out.println("=======>我是导游，本次点名结束，准备走下一个环节");
                }
            });

    public static void main(String[] args) throws InterruptedException,BrokenBarrierException{
        for (int i =0; i < 10; i++){
            new Thread(String.valueOf(i)){
                @Override
                public void run() {
                    try {
                        System.out.println("我是线程：" + this.getName() + " 我们到达旅游地点！");
                        CYCLIC_BARRIER.await();
                        System.out.println("我是线程：" + this.getName() + " 我们开始骑车！");
                        CYCLIC_BARRIER.await();
                        System.out.println("我是线程：" + this.getName() + " 我们开始爬山！");
                        CYCLIC_BARRIER.await();
                        System.out.println("我是线程：" + this.getName() + " 我们回宾馆休息！");
                        CYCLIC_BARRIER.await();
                        System.out.println("我是线程：" + this.getName() + " 我们开始乘车回家!");
                        CYCLIC_BARRIER.await();
                        System.out.println("我是线程：" + this.getName() + " 我们到家了！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}

