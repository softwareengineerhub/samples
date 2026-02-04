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
public class Main {
    
    public static void main(String[] args) {
        A a = new A("name");
        System.out.println("-----------------");
        A a1 = new A(1);
        
        //new Thread().join();
        Thread.yield();
        //Thread.sleep(1000);
        
        a1.notifyAll();
        
    }
    
}
