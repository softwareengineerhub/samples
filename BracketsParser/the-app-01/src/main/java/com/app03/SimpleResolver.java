package com.app03;

import com.app01.MySimpleParser;

public class SimpleResolver {

    //2*x+5=17
    public boolean isSolution(String text, double x){
        int position = text.indexOf("=");
        //"2*x+5"
        String left = text.substring(0, position);
        //"17"
        String right = text.substring(position+1);
        //17
        double expectedResult = Double.parseDouble(right);

        MySimpleParser mySimpleParser = new MySimpleParser();
        //"2*x+5"
        String parameter = left.replace("x", x+"");

        //"2*6+5"
        double calcResult = mySimpleParser.calculate(parameter);

        return expectedResult==calcResult;
    }

}
