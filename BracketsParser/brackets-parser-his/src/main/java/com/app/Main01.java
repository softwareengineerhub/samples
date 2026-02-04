package com.app;

import SimpleParser.ParserBase;
import SimpleParser.ParserException;
import SimpleParser.RecursiveParser.ParserRecursive;

public class Main01 {

    public static void main(String[] args) throws ParserException {
        //ParserBase parserBase = new ParserRecursive();
        //double result = parserBase.evaluate("((3+6)-2)*3+9");

        ParserBase parserBase = new MySimpleRecursiveParser();
        //double result = parserBase.evaluate("3+4*5");
        //System.out.println("result="+result);
        double result2 = parserBase.evaluate("3+4*5-10*2+3");
        System.out.println("result2="+result2);
        double result3 = parserBase.evaluate("3+4*5-10*2*4");
        System.out.println("result3="+result3);
    }

}
