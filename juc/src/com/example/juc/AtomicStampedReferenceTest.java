package com.example.juc;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * User: guorui
 * Date: 13-7-23
 * Time: 上午9:47
 */
public class AtomicStampedReferenceTest {

    public final static AtomicStampedReference<String> ATOMIC_STAMPED_REFERENCE = new AtomicStampedReference<String>("abc", 0);

    public static void main(String[] args) {

    }
}
