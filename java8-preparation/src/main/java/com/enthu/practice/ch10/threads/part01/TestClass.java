package com.enthu.practice.ch10.threads.part01;

public class TestClass implements Runnable{
    private SomeData someData;

    @Override
    public void run() {
        System.out.println("someDate="+someData.hashCode());
        System.out.println("myKey="+someData.getMyKey().hashCode());
    }

    public SomeData getSomeData() {
        return someData;
    }

    public void setSomeData(SomeData someData) {
        this.someData = someData;
    }
}
