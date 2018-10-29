/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.design.net.app;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void m(int i){
        System.out.println("int i="+i);
    }
    
    public static void m(Integer i){
        System.out.println("Integer i="+i);
    }
    
    public static void m(long i){
        System.out.println("long i="+i);
    }
    
    public static void m(Long i){
        System.out.println("Long i="+i);
    }
    
    public static void main(String[] args) {
        Integer a = 1;
        m(a);
        int b = 2;
        m(b);
    }
    
}
