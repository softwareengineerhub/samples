/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithm.tasks.sumofnumbers;

/**
 *
 * @author Denis
 */
public class SumOfNumbers {
 
    public int sumOfNumbers(int value){
        int sum = 0;
        while(value%10!=0){
            sum+=value%10;
            value = value/10;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        SumOfNumbers sumOfNumbers = new SumOfNumbers();
        int res=sumOfNumbers.sumOfNumbers(123);
        System.out.println("res="+res);
    }
    
}
