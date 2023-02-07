package com.book.ch11.concur.app02;

import java.util.concurrent.CyclicBarrier;

public class MyCyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(2);

        Thread t1 = new Thread() {

            @Override
            public void run() {
                try {
                    System.out.println("T1 STARTED");
                    Thread.sleep(1000);
                    System.out.println("T1 Before barrier");
                    cb.await();
                    System.out.println("T1 After barrier");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t2 = new Thread() {

            @Override
            public void run() {
                try {
                    System.out.println("T2 STARTED");
                    Thread.sleep(9000);
                    System.out.println("T2 Before barrier");
                    cb.await();
                    System.out.println("T2 After barrier");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        t1.start();
        t2.start();


    }

}
