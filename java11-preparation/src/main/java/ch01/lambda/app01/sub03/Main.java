/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app01.sub03;

/**
 *
 * @author DProkopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        
        MyInterface3 myInterface3 = (a, b) -> 1;
        System.out.println(myInterface3.doAction("1", "2"));
        System.out.println("-----------------------------");
        
        myInterface3 = (String a, String b) -> 1;
        System.out.println(myInterface3.doAction("1", "2"));
        System.out.println("-----------------------------");
        
        myInterface3 = (String a, String b) -> {return 1;};
        System.out.println(myInterface3.doAction("1", "2"));
        System.out.println("-----------------------------");
        
        myInterface3 = (a, b) -> {return a.length()+b.length();};
        System.out.println(myInterface3.doAction("1", "2"));
        System.out.println("-----------------------------");
        
        myInterface3 = (a, b) -> a.length()+b.length();
        System.out.println(myInterface3.doAction("1", "2"));
        System.out.println("-----------------------------");       
        
    }
    
}
