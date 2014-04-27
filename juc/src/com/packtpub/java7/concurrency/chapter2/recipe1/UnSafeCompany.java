package com.packtpub.java7.concurrency.chapter2.recipe1;

/**
 * This class simulates a company that pays a salary an
 * insert money into an account.
 */
public class UnSafeCompany implements Runnable {

    private UnSafeAccount account;

    public UnSafeCompany(UnSafeAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            account.addAmount(1000);
        }
    }
}
