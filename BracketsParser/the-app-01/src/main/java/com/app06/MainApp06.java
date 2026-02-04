package com.app06;

public class MainApp06 {

    public static void main(String[] args) {
        //"2*-6-5"
        //String text = ;
        //String text2 = text.replaceAll("\\*-", "");
        //"26-5"

        /*result = parser5.calculate("2*-6-5");
        //double result = parser5.calculate("2*-6");
        System.out.println("result="+result);

        result = parser5.calculate("12/-6-5");
        System.out.println("result="+result);
        result = parser5.calculate("12/-6");*/


        MySimpleCalculator06 calculator = new MySimpleCalculator06();
        //double result = calculator.calculate("2*x-5", -6);
        //double result = calculator.calculate("2*x-5", -6);
        double result = calculator.calculate("12/x-5", -6);
        System.out.println("result="+result);

    }

}
