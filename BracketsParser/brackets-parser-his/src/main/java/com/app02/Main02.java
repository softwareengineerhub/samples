package com.app02;

import SimpleParser.ParserBase;
import SimpleParser.ParserException;
import com.app.MySimpleRecursiveParser;

public class Main02 {

    public static void main(String[] args) throws ParserException {
        ParserBase parserBase = new MyRecursiveParser();
        //double result = parserBase.evaluate("((3+6)-2)*3+9");
        //double result = parserBase.evaluate("((4+5)*2)*(3+1)");
        //double result = parserBase.evaluate("((4+5)+2)+(3+1)");
        //double result = parserBase.evaluate("(3+1)");
        //double result = parserBase.evaluate("((4+5)+2)");
        double result = parserBase.evaluate("((4+5)+2)+(3+1)");
        System.out.println("result="+result);
    }

}
