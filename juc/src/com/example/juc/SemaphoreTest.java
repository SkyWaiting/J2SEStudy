package com.example.juc;

import com.example.tools.DateTimeUtil;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-7-5
 * Time: 下午5:24
 * To change this template use File | Settings | File Templates.
 */
public class SemaphoreTest {
    private final static Semaphore MAX_SEMA_PHORE = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            final int num = i;
            final Random random = new Random();
            new Thread() {
                public void run() {
                    boolean acquired = false;
                    try {
                        MAX_SEMA_PHORE.acquire();
                        acquired = true;
                        System.out.println("我是线程：" + num + "我获得了使用权！" + DateTimeUtil.getLongToday());
                        long time = 1000 * Math.max(1, Math.abs(random.nextInt() % 10));
                        Thread.sleep(time);
                        System.out.println("我是线程：" + num + "我执行完了！" + DateTimeUtil.getLongToday());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if (acquired) {
                            MAX_SEMA_PHORE.release();
                        }
                    }

                }
            }.start();
        }
    }
}
