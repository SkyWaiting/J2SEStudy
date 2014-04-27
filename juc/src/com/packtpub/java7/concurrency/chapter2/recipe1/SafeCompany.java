package com.packtpub.java7.concurrency.chapter2.recipe1;

/**
 * Created by guorui on 14-4-26.
 */
public class SafeCompany implements Runnable {

    private SafeAccount account = new SafeAccount();

    public SafeCompany(SafeAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.addAmount(1000);
        }
    }
}
