package com.app;

import SimpleParser.ParserBase;
import SimpleParser.ParserException;

public class MySimpleRecursiveParser extends ParserBase {

    //"3+4*5"
    @Override
    public double evaluate(String text) throws ParserException {
        //return (text.substring(0, indexof('-') - 1) - s.substring(indexof('-') + 1, s.length));

        if (text.contains("-")) {
            int index = text.indexOf("-", 0);
            double a = evaluate(text.substring(0, index));
            double b = evaluate(text.substring(index+1, text.length()));
            return a-b;
        } else if (text.contains("+")) {
            int index = text.indexOf("+", 0);
            double a = evaluate(text.substring(0, index));
            double b = evaluate(text.substring(index+1, text.length()));
            System.out.println("a="+a);
            System.out.println("b="+b);
            return a+b;
        } else if (text.contains("*")) {
            int index = text.indexOf("*", 0);
            double a = evaluate(text.substring(0, index));
            double b = evaluate(text.substring(index+1, text.length()));
            System.out.println("a="+a);
            System.out.println("b="+b);
            return a*b;
        } else if (text.contains("/")) {
            int index = text.indexOf("/", 0);
            double a = evaluate(text.substring(0, index));
            double b = evaluate(text.substring(index+1, text.length()));
            return a/b;
        }
        return Double.parseDouble(text);
    }

    private double evaluate(String text, double result, String lastOperation){
return 0;
    }

}
