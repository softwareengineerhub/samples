package com.enthu.practice.ch10.threads.part02;

public class A extends Thread {
    static protected int i = 0;

    public void run() {
        for (; i < 5; i++) {
            System.out.println("Hello");
        }
    }

}
