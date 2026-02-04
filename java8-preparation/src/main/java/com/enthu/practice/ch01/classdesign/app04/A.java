/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enthu.practice.ch01.classdesign.app04;

/**
 *
 * @author admin
 */
public class A {
    
    private A(){
        System.out.println("private A()");
    }
    
    public A(String name){
        this();
        System.out.println("name="+name);
    }
    
    public A(int age){
        System.out.println("age="+age);
    }
    
   
    
}
