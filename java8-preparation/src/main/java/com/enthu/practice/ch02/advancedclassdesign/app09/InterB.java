/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enthu.practice.ch02.advancedclassdesign.app09;

/**
 *
 * @author admin
 */
public interface InterB extends InterA {
    
    public default String makeAction(){
        return "InterB";
    }
    
}
