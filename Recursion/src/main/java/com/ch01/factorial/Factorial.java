/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch01.factorial;

/**
 *
 * @author prokopiukd
 */
public class Factorial {

    public int factorial(int n) {
        if (n <= 1) {
            return n;
        }
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int value=factorial.factorial(5);
        System.out.println("value="+value);
    }

}
