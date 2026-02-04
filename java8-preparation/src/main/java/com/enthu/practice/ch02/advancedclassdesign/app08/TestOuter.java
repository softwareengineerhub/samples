package com.enthu.practice.ch02.advancedclassdesign.app08;

public class TestOuter {
    int i=10;

    public void myMethod(){
        new TestInner();
        new TestOuter.TestInner();
        new TestOuter(). new TestInner();
        
        TestOuter to = new TestOuter();
        to.new TestInner();
    }

    public static void main(String[] args) {
        TestOuter to = new TestOuter();
        //new TestOuter.TestInner();
//        to.new TestInner();

    }


    class TestInner{
        
        public void mA(){
            System.out.println("i="+i);
        }

    }
}
