package com.enthu.practice.ch06.exceptions.app02;

public class MyClose2 implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("MyClose2");
        String s = null;
        s.toCharArray();
    }
}
