package com.example.juc;

import java.util.concurrent.Exchanger;

/**
 * 线程之间交互数据，且在并发时候使用，两两交换，
 * 交换中不会因为线程多而混乱，发送出去没接收到会一直等，
 * 由交互器完成交互过程
 * User: guorui
 * Date: 13-7-17
 * Time: 下午4:12
 */
public class ExchangerTest {
    public static void main(String[] args) {
        final Exchanger<Integer> exchanger = new Exchanger<Integer>();
        for (int i = 0; i < 10; i++) {
            final Integer num = i;
            new Thread() {
                public void run() {
                    System.out.println("我是线程：Thread_" + this.getName() + "我的数据是：" + num);
                    try {
                        Integer exchangeNum = exchanger.exchange(num);
                        Thread.sleep(1000);
                        System.out.println("我是线程：Thread_" + this.getName() + "我原先的数据为：" +
                                num + ",交换后的数据为：" + exchangeNum);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
