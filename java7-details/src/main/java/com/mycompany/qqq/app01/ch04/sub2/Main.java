/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qqq.app01.ch04.sub2;

/**
 *
 * @author asusadmin
 */
public class Main {

    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println(parent.name);
        Child child = new Child();
        System.out.println(child.name);
        Parent p1 = new Child();
        System.out.println(p1.name);
    }

}
