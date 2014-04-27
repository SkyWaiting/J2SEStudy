package com.packtpub.java7.concurrency.chapter2.recipe1;

/**
 * Created by guorui on 14-4-26.
 */
public class UnSafeMain {
    public static void main(String[] args) {
        //创建一个新的账户
        UnSafeAccount unSafeAccount = new UnSafeAccount();
        //初始化账户余额为1000元
        unSafeAccount.setBalance(1000);

        //创建一个公司线程并运行其任务
        UnSafeCompany unSafeCompany = new UnSafeCompany(unSafeAccount);
        Thread companyThread = new Thread(unSafeCompany);

        //创建一个银行线程并运行其任务
        UnSafeBank unSafeBank = new UnSafeBank(unSafeAccount);
        Thread bankThread = new Thread(unSafeBank);

        //打印账户初始余额
        System.out.printf("Account : Initial Balance: %f\n",unSafeAccount.getBalance());

        //开始执行线程
        companyThread.start();
        bankThread.start();

        try {
            //等待所有线程结束
            companyThread.join();
            bankThread.join();
            //打印账户最终余额
            System.out.printf("Account : Final Balance: %f\n",unSafeAccount.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
