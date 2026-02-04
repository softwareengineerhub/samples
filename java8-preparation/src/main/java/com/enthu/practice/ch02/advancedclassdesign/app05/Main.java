package com.enthu.practice.ch02.advancedclassdesign.app05;

public class Main {

    public static void main(String[] args) {
        B b = new BImpl();
        String s = b.getId();
        System.out.println("s="+s);

        //compilation issue
        //b.getId2();
    }

}
