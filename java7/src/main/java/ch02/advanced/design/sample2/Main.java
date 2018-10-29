/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.advanced.design.sample2;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
 
    public static void main(String[] args) {
        MyOuterClass my1 = new MyOuterClass(){}.new MyInnerClass();
        
    }
    
    
}
