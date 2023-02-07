package com.book.ch11.concur.app01;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicCas {

    public static void main(String[] args) {
        AtomicInteger value = new AtomicInteger(10);
        int res = getAndIncrement(value);
        System.out.println("res="+res);
    }

    private static int getAndIncrement(AtomicInteger value){
        for(;;){
            int current = value.get();
            int next = current+1;
            if(value.compareAndSet(current, next)){
                System.out.println("value="+value);
                return current;
            }
        }
    }


}
