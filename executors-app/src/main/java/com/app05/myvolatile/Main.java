package com.app05.myvolatile;

public class Main {

    public static void main(String[] args) {
        MyVolaData myVolaData = new MyVolaData();
        Thread producer = new MyVolaProducer(myVolaData);
        Thread consumer = new MyVolaConsumer(myVolaData);
        producer.start();
        consumer.start();
    }

}
