/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch01.fibonacci;

/**
 *
 * @author prokopiukd
 */
public class Fibonacci {
    
    public int fibonacci(int n){
        if(n<=1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int res = fibonacci.fibonacci(17);
        System.out.println("fibonacci="+res);
    }
    
}
