package com.app04;

public class Main04App {

    public static void main(String[] args) {
        MySimpleParser4 parser4 = new MySimpleParser4();
        //-1.3*5/x=1.2
        //-6.5/2 = - 3.25
        double result = parser4.calculate("-1.3*5/2");
        System.out.println("result="+result);

        //-1.3/5*2
        //-0.52
        result = parser4.calculate("-1.3/5*2");
        System.out.println("result="+result);

        System.out.println("----------issue-------");
        //-7 --> -1
        result = parser4.calculate("2*-6+5");
        System.out.println("result="+result);


    }

}
