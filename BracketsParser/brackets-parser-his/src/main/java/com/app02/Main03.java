package com.app02;

import SimpleParser.ParserBase;
import SimpleParser.ParserException;
import SimpleParser.RecursiveParser.ParserRecursive;

public class Main03 {

    public static void main(String[] args) throws ParserException {
        ParserBase parserBase = new ParserRecursive();
        //double result = parserBase.evaluate("((3+6)-2)*3+9");
        //double result = parserBase.evaluate("((4+5)*2)*(3+1)");
        //double result = parserBase.evaluate("((4+5)+2)+(3+1)");
        //double result = parserBase.evaluate("((4+5)+2)");

        double result = parserBase.evaluate("-1.3*-6/2");
        System.out.println("result="+result);
    }

}
