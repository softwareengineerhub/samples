package com.enthu.practice.ch02.advancedclassdesign.app02;

public enum Pets {

    DOG("D"), CAT("C"), FISH("F");

    String name;
    static String prefix ="I am";


    Pets(String s){
        //can not access a non-final field from an enum's constructor
        //this.name=prefix+s;
    }

    //2 ?

}
