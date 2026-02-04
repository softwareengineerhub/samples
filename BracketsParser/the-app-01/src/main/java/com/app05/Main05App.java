package com.app05;


public class Main05App {

    public static void main(String[] args) {
        MySimpleParser5 parser5 = new MySimpleParser5();
        System.out.println("----------solution 5-------");
        //-7 --> -1
        double result = parser5.calculate("2*-6+5");
        System.out.println("result="+result);

        System.out.println("----------solution 5-------");
        //-7 --> -1
        result = parser5.calculate("2*-6-5");
        //double result = parser5.calculate("2*-6");
        System.out.println("result="+result);

        result = parser5.calculate("12/-6-5");
        System.out.println("result="+result);
        result = parser5.calculate("12/-6");
        System.out.println("result="+result);

        // *-
        // /-

    }

}
