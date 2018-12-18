/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qqq.app04;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main04 {

    public static void main(String[] args) {
        int i = 1;
        Integer j = 2;
        byte b = 2;
        short sh = 3;
        m(i);
        m(j);        
        m(b);
        m(sh);
    }

    /*public static void m(int i) {
        System.out.println("int");
    }

    public static void m(Integer i) {
        System.out.println("Integer");
    }*/
    
    public static void m(long i) {
        System.out.println("long");
    }
    
    public static void m(Long i) {
        System.out.println("Long");
    }

}
