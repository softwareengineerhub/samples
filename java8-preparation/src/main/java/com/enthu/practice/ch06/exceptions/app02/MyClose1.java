package com.enthu.practice.ch06.exceptions.app02;

public class MyClose1 implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("MyClose1");
    }
}
