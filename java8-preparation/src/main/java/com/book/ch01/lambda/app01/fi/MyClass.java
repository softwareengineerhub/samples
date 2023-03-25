package com.book.ch01.lambda.app01.fi;

public class MyClass implements MyInter, MyInter2 {
    @Override
    public void doAction() {
        //super.doAction();
        MyInter2.super.doAction();
    }



}
