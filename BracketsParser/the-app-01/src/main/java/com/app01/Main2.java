package com.app01;

public class Main2 {

    public static void main(String[] args) {
        String text ="3";
        MySimpleParser mySimpleParser = new MySimpleParser();
        double result = mySimpleParser.calculate(text);
        System.out.println("result="+result);
    }

}
