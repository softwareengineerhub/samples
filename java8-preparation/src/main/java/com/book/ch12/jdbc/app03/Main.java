package com.book.ch12.jdbc.app03;

public class Main {

    public static void main(String[] args)  {
        MyThread my = new MyThread(){
            @Override
            public void run() {
                System.out.println("cccc");
            }
        };
        my.start();
        //my.join();
        Thread.yield();
    }
}
