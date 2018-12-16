/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qqq.app01.ch06;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main6 {
    
    public static void main(String[] args) {
        MyParent6 myParent6 = new MyParent6();
        MyChild6 myChild6 = new MyChild6();
        MyParent6 p1 = new MyChild6();
        System.out.println(myParent6.getText());
        System.out.println(myChild6.getText());
        System.out.println(p1.getText());
    }
    
}
