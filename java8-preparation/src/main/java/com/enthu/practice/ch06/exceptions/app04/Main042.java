/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enthu.practice.ch06.exceptions.app04;

/**
 *
 * @author admin
 */
public class Main042 {
    
    public static void main(String[] args) {
        new Main042().getItDone(-4);
    }
    
    public void getItDone(int counter)    { 
        assert counter < 100 : "Greater than 100";   
        for(int i=counter; i>0; i--){
        }    
    }
    
}
