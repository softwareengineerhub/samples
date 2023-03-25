package com.book.ch01.lambda.app01.fi;

public interface MyInter2 {

    default public void doAction(){
        System.out.println("MyInter2.doAction()");
    }

}
