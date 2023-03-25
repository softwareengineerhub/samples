package com.book.ch01.lambda.app01.fi;

public interface MyInter {

    default public void doAction(){
        System.out.println("MyInter.doAction()");
    }

}
