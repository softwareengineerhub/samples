package com.enthu.practice.ch06.exceptions.app01;

public class MyAutocloseable2 implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("close2");
    }




}
