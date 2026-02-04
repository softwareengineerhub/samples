package com.enthu.practice.ch02.advancedclassdesign.app03;

public interface B {

    public default String getId(){
        return "";
    }

    //compilation issue
    //public String getId();

}
