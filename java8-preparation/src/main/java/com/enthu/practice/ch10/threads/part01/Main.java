package com.enthu.practice.ch10.threads.part01;

public class Main {

    public static void main(String[] args) {
        TestClass tc = new TestClass();
        SomeData someData = new SomeData();
        someData.setMyKey(new MyKey());
        tc.setSomeData(someData);

        Thread t1 = new Thread(tc);
        Thread t2 = new Thread(tc);
        t1.start();
        t2.start();

    }

}
