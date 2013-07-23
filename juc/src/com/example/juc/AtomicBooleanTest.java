package com.example.juc;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 主要方法：
 *
 * @see AtomicBoolean#compareAndSet(boolean, boolean) 第一个参数为原始值，
 *      第二个参数为要修改的新值，若修改成功则返回true,否则返回false.
 * @see AtomicBoolean#getAndSet(boolean) 以原子方式设置为给定的值，并返回以前的值。
 *      User: guorui
 *      Date: 13-7-22
 *      Time: 下午9:26
 */
public class AtomicBooleanTest {

    public final static AtomicBoolean TEST_BOOLEAN = new AtomicBoolean();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (TEST_BOOLEAN.compareAndSet(false, true)) {
                        System.out.println("我成功了！");
                    }
                }
            }.start();
        }
    }
}
