/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qqq.app01;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        Parent p = new Child();
        System.out.println(parent.name);
        System.out.println(child.name);
        System.out.println(p.name);
    }
    
}
