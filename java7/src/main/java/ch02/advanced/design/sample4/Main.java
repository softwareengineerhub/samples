/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.advanced.design.sample4;

import ch02.advanced.design.sample4.TestClassS4.MyInnerClass4;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        TestClassS4 s4 = new TestClassS4();
        MyInnerClass4 inner4 = s4.new MyInnerClass4();
        inner4.m4();
        System.out.println(s4.getName());
    }
    
}
