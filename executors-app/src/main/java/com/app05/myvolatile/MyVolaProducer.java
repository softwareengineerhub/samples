package com.app05.myvolatile;

public class MyVolaProducer extends Thread {
    private MyVolaData myVolaData;

    public MyVolaProducer(MyVolaData myVolaData) {
        this.myVolaData = myVolaData;
    }

    public void run(){
        try {
            System.out.println("Producer. START");
            Thread.sleep(1000);
            for(int i=0;i<5;i++){
                System.out.println("Produced: "+myVolaData.produceNext());
                Thread.sleep(1000);
            }
            System.out.println("Producer. FINISHED");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
