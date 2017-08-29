/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithm.tasks.fibonacci;

import java.util.Arrays;

/**
 *
 * @author Denis
 */
public class Fibonacci {
    
    public int[] init(int n){
        int[] data = new int[n];
        data[0]=0;
        data[1]=1;
        for(int i=2;i<n;i++){
            data[i] = data[i-2]+data[i-1];
        }
        return data;
    }
    
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int[] data = fibonacci.init(15);
        System.out.println(Arrays.toString(data));
    }
}
