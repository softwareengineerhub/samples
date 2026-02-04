package com.enthu.practice.ch06.exceptions.app01;

public class MyAutocloseable implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("close");
    }




}
