/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qqq.app01.ch05;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main5 {

    public static void main(String[] args) {
        MyParent5 parent = new MyParent5();
        MyChild5 child = new MyChild5();
        MyParent5 p1 = new MyChild5();
        System.out.println(parent.getText());
        System.out.println(child.getText());
        System.out.println(p1.getText());
    }

}
