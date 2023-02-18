package com.book.ch10.threads.checkexceptions;

public class AppThread01 {

    public static void main(String[] args) {

        Thread.yield(); //no Exception

        Thread t1 = null;
        Thread t2 = null;
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
