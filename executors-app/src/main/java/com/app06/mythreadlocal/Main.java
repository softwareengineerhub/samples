package com.app06.mythreadlocal;

public class Main {

    public static void main(String[] args) {
        MyData myData = new MyData();
        Thread t1 = new MyThread(myData, "t1");
        Thread t2 = new MyThread(myData, "t2");
        Thread t3 = new MyThread(myData, "t3");

        t1.start();
        t2.start();
        t3.start();
    }

}
