package com.packtpub.java7.concurrency.chapter1.recipe2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-11-16
 * Time: 上午10:03
 *
 */
public class Main {
    public static void main(String[] args) {

        //Thread priority information
        System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n",Thread.NORM_PRIORITY);
        System.out.printf("Maximum Priority: %s\n",Thread.MAX_PRIORITY);

        Thread threads[];
        Thread.State status[];

        threads = new Thread[10];
        status = new Thread.State[10];

        for (int i=0; i<10; i++){
            threads[i] = new Thread(new Calculator(i));
            if ((i%2) ==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread "+i);
        }

        //Wait for the finalization of the threads.Meanwhile,
        //write the status of those threads in a file.
        try (FileWriter file = new FileWriter("/Users/guorui/Codes/IdeaProjects/J2SEStudy/juc/src/com/packtpub/java7/concurrency/chapter1/recipe2/data/log.txt");PrintWriter pw = new PrintWriter(file)){

            for (int i=0; i<10; i++){
                pw.println("Main : Status of Thread "+i+" : "+threads[i].getState());
                status[i]=threads[i].getState();
            }

            for (int i=0; i<10; i++){
                threads[i].start();
            }

            boolean finish = false;
            while (!finish){
                for (int i=0; i<10; i++){
                    if (threads[i].getState() != status[i]){
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }

                finish=true;
                for (int i=0; i<10; i++){
                    finish=finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state){
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ***********************************\n");
    }
}
