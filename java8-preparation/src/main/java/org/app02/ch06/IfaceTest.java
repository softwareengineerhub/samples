/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app02.ch06;

/**
 *
 * @author dprokopiuk
 */
public class IfaceTest implements MyInterface {

    public static void main(String[] args) {
        new IfaceTest().go();
    }

    void go() {
        System.out.println("class: "+doStuff());
        System.out.println("class: "+MyInterface.super.doStuff());
    }

    @Override
    public int doStuff() {
        return 43;
    }

}
