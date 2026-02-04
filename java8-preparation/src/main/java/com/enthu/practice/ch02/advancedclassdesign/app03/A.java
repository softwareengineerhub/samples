package com.enthu.practice.ch02.advancedclassdesign.app03;

public interface A {

    public default String getId(){
        return "";
    }

    //compilation issue
    /*public static String getId(){
        return "";
    }*/

}
