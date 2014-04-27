package com.packtpub.java7.concurrency.chapter2.recipe1;

/**
 * This class simulates a bank or a crash dispenser that takes money
 * from an account.
 */
public class UnSafeBank implements Runnable {

    /**
     *  The account affected by the operation.
     */
    private UnSafeAccount account;

    public UnSafeBank(UnSafeAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            account.subtractAccount(1000);
        }
    }
}
