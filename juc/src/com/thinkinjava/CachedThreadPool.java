package com.thinkinjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1.Executor接口(执行器)在客户端和任务执行之间提供了一个间接曾，允许你管理异步任务的执行，而
 * 无须显式的管理进程的生命周期
 * 2.ExecutorService是具有服务生命周期的Executor，它知道如何构建恰当的上下文执行Runnable对象
 * 3.Executors.newCachedThreadPool() 创建一个可根据需要创建新线程的线程池，
 * 但是在以前构造的线程可用时将重用它们。对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能。
 * 调用 execute 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，
 * 则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程
 * User: guorui
 * Date: 14-1-4
 * Time: 上午9:47
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }

}
