/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app01.sub01;

/**
 *
 * @author DProkopiuk
 */
public class Main1 {

    public static void main(String[] args) {
        MyInterface1 myInterface1 = (s) -> {
            System.out.println(s);
        };
        myInterface1.doAction("action1.0");
        System.out.println("-----------------------------------");
        myInterface1 = (String s) -> {            
            System.out.println(s);
        };
        myInterface1.doAction("action1.1");
        System.out.println("-----------------------------------");
        myInterface1 = s -> {
            System.out.println(s);
        };
        myInterface1.doAction("action1.2");
    }

}
