/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qqq.app01.ch04;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main4 {

    public static void main(String[] args) {
        MyParent4 myParent = new MyParent4();
        MyChild4 myChild = new MyChild4();
        MyParent4 p1 = new MyChild4();
        System.out.println(myParent.name);
        System.out.println(myChild.name);
        System.out.println(p1.name);
        System.out.println(MyParent4.name);
        System.out.println(MyChild4.name);
    }

}
