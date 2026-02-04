package com.app06.mythreadlocal;

public class MyThread extends Thread {
    private MyData myData;

    public MyThread(MyData myData, String name) {
        this.myData = myData;
        this.setName(name);
    }

    public void run(){
        try {
            System.out.println("STARTED: "+Thread.currentThread().getName());
            Thread.sleep(5000);
            for(int i=0;i<1000;i++){
                Thread.sleep(5);
                myData.value.get().incrementAndGet();
            }
            System.out.println("FINISHED: "+Thread.currentThread().getName()+"; value="+myData.value.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
