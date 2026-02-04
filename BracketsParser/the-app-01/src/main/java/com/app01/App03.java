package com.app01;

public class App03 {

    public static void main(String[] args) {
        //23-5+3=21
        String text ="3+4*5-10/2+3";
        MySimpleParser mySimpleParser = new MySimpleParser();
        double result = mySimpleParser.calculate(text);
        System.out.println("result="+result);










        /*int t=1;
        Integer t2 = 1;

        double q =1.0;
        Double q2 = 2.0;*/
    }

}
