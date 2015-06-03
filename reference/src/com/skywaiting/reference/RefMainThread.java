package com.skywaiting.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.ref.PhantomReference;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 2015/6/3
 * Time: 16:54
 * 软引用 (SoftReference), 引用类型表现为当内存接近满负荷 , 
 *    或对象由 SoftReference.get() 方法的调用没有发生一段时间后 , 垃圾回收器将会清理该对象 . 
 *    在运行对象的 finalize 方法前 , 会将软引用对象加入 ReferenceQueue 中去 .
 * 弱引用 (WeakReference), 引用类型表现为当系统垃圾回收器开始回收时 , 则立即会回收该对象的引用 . 
 *    与软引用一样 , 弱引用也会在运行对象的 finalize 方法之前将弱引用对象加入 ReferenceQueue.
 * 强引用 (FinalReference), 这是最常用的引用类型 . JVM 系统采用 Finalizer 来管理每个强引用对象 , 
 *    并将其被标记要清理时加入 ReferenceQueue, 并逐一调用该对象的 finalize() 方法 .
 * 虚引用 (PhantomReference), 这是一个最虚幻的引用类型 . 
 *    无论是从哪里都无法再次返回被虚引用所引用的对象 . 虚引用在系统垃圾回收器开始回收对象时 , 
 *    将直接调用 finalize() 方法 , 但不会立即将其加入回收队列 . 只有在真正对象被 GC 清除时 , 
 *    才会将其加入 Reference 队列中去
 *
 *
 */
public class RefMainThread {
    public static void main(String[] args) {
        //创建三种不同的引用类型所需的对象
        RefTestObj softRef = new RefTestObj();
        RefTestObj weakRef = new RefTestObj();
        RefTestObj phanRef = new RefTestObj();
        
        softRef.setId(1);
        weakRef.setId(2);
        phanRef.setId(3);

        ReferenceQueue<RefTestObj> softRefQueue = new ReferenceQueue<RefTestObj>();
        ReferenceQueue<RefTestObj> weakRefQueue = new ReferenceQueue<RefTestObj>();
        ReferenceQueue<RefTestObj> phanRefQueue = new ReferenceQueue<RefTestObj>();

        SoftReference<RefTestObj> softRefObj = new SoftReference<RefTestObj>(softRef,softRefQueue);
        WeakReference<RefTestObj> weakRefObj = new WeakReference<RefTestObj>(weakRef,weakRefQueue);
        PhantomReference<RefTestObj> phanRefObj = new PhantomReference<RefTestObj>(phanRef,phanRefQueue);
        
        //打印正常情况下三种对象引用
        

    }
}
