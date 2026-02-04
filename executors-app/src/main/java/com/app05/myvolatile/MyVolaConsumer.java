package com.app05.myvolatile;

public class MyVolaConsumer extends Thread {

    private MyVolaData myVolaData;

    public MyVolaConsumer(MyVolaData myVolaData) {
        this.myVolaData = myVolaData;
    }

    public void run(){
        try {
            System.out.println("Consumer START");
            int localValue = myVolaData.getValue();
            while(localValue<5){
                if(localValue!=myVolaData.getValue()){
                    localValue = myVolaData.getValue();
                    System.out.println("Consumed: "+localValue);
                }
            }
            System.out.println("Consumer FINISH");
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
