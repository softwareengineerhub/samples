package com.book.ch07.innerclasses;

public class Main {

    public static void main(String[] args) {

        //MyOuter.MyInner myInner = new MyOuter(). new MyInner();
        MyOuter myOuter = new MyOuter();
        MyOuter.MyInner myInner = myOuter.new MyInner();


        MyOuter.MyInner2 myInner2 = new MyOuter.MyInner2();


    }

}
