/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithm.tasks.revertnumber;

/**
 *
 * @author Denis
 */
public class RevertNumber {
    
    public int revert(int value){
        int result = 0;
        while(value%10!=0){
            result=result*10+value%10;
            value=value/10;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int value = 123;
        RevertNumber revertNumber = new RevertNumber();
        int result = revertNumber.revert(value);
        System.out.println("result="+result);
    }
    
}
