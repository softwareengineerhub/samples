/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app01.sub02;

/**
 *
 * @author DProkopiuk
 */
public class Main {

    public static void main(String[] args) {
        MyInterface2 myInterface2 = s -> 1;
        System.out.println(myInterface2.doAction("a"));
        System.out.println("------------------------"+myInterface2.hashCode());

        myInterface2 = (s) -> 1;
        System.out.println(myInterface2.doAction("a"));
        System.out.println("------------------------"+myInterface2.hashCode());

        myInterface2 = (String s) -> 1;
        System.out.println(myInterface2.doAction("a"));
        System.out.println("------------------------"+myInterface2.hashCode());
        
        myInterface2 = (s) -> {return 1;};
        System.out.println(myInterface2.doAction("a"));
        System.out.println("------------------------");
        
        myInterface2 = (s) -> {return s.length();};
        System.out.println(myInterface2.doAction("a"));
        System.out.println("------------------------");
        
        myInterface2 = (s) -> s.length()+10;
        System.out.println(myInterface2.doAction("a"));
        System.out.println("------------------------");

    }

}
