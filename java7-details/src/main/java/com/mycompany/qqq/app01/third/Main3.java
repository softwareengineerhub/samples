/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qqq.app01.third;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main3 {

    public static void main(String[] args) {
        MyParent2 myParent = new MyParent2();
        MyChild2 myChild = new MyChild2();
        MyParent2 p1 = new MyChild2();
        System.out.println(myParent.name);
        System.out.println(myChild.name);
        System.out.println(p1.name);
    }

}
