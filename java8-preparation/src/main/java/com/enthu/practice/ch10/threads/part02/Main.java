package com.enthu.practice.ch10.threads.part02;

import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
        Thread t1 = new A();
        Thread t2 = new TestClass();
        t2.start();
        t1.start();
    }

}
