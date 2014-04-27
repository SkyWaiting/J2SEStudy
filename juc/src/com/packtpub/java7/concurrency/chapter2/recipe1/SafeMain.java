package com.packtpub.java7.concurrency.chapter2.recipe1;

/**
 * Created by guorui on 14-4-26.
 */
public class SafeMain {
    public static void main(String[] args) {
        //创建一个新的账户
        SafeAccount safeAccount = new SafeAccount();
        //初始化账户余额为1000元
        safeAccount.setBalance(1000);

        //创建一个公司线程并运行其任务
        SafeCompany safeCompany = new SafeCompany(safeAccount);
        Thread companyThread = new Thread(safeCompany);

        //创建一个银行线程并运行其任务
        SafeBank safeBank = new SafeBank(safeAccount);
        Thread bankThread = new Thread(safeBank);

        //打印账户初始余额
        System.out.printf("Account : Initial Balance: %f\n",safeAccount.getBalance());

        //开始执行线程
        companyThread.start();
        bankThread.start();

        try {
            //等待所有线程结束
            companyThread.join();//主线程停止直到companyThread线程运行完毕
            bankThread.join();//主线程停止直到bankThread线程运行完毕
            //打印账户最终余额
            System.out.printf("Account : Final Balance: %f\n",safeAccount.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
