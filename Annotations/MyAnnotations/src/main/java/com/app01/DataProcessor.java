/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01;

public class DataProcessor {
    
    @TypeA()
    public void doAction(){
        System.out.println("Inside doAction()");
    }
    
    
    @TypeA(enabled = true, message = "message")
    public void doAction2(){
        System.out.println("Inside doAction2()");
    }
    
    
    @TypeA(enabled = false, message = "messag3")
    public void doAction3(){
        System.out.println("Inside doAction3()");
    }
    
}
