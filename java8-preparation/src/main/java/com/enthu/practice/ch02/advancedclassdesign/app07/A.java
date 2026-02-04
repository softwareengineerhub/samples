package com.enthu.practice.ch02.advancedclassdesign.app07;

public interface A {

    public void m1();

    public default void doAction(){
        System.out.println("doAction");
        m1();
    }

}
