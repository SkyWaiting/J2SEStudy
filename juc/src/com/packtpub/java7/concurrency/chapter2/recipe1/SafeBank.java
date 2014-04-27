package com.packtpub.java7.concurrency.chapter2.recipe1;

/**
 * Created by guorui on 14-4-26.
 */
public class SafeBank implements Runnable {

    private SafeAccount account = new SafeAccount();

    public SafeBank(SafeAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.subtrackAmount(1000);
        }
    }
}
