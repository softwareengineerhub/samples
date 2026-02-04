package com.app06.mythreadlocal;

public class Main2 {

    public static void main(String[] args) {
        MyData myData = new MyData();
        Thread t1 = new MyThread2(myData, "t1");
        Thread t2 = new MyThread2(myData, "t2");
        Thread t3 = new MyThread2(myData, "t3");

        t1.start();
        t2.start();
        t3.start();
    }

}
