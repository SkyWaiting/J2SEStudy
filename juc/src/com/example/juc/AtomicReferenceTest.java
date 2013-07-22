package com.example.juc;

import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * User: guorui
 * Date: 13-7-22
 * Time: 下午9:42
 *
 */
public class AtomicReferenceTest {

    public final static AtomicReference<String> ATOMIC_REFERENCE = new AtomicReference<String>("abc");

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            final int num = i;
            new Thread(){
                @Override
                public void run(){
                    try {
                        Thread.sleep(Math.abs((int)(Math.random() * 100)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (ATOMIC_REFERENCE.compareAndSet("abc",new String("abc"))){
                        System.out.println("我是线程：" + num +"，我获得了锁进行了对象修改！");
                    }
                }
            }.start();
        }
    }
}
