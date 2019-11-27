/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app02.ch05;

/**
 *
 * @author dprokopiuk
 */
public class MultiInt implements I1, I2 {

    public static void main(String[] args) {
        new MultiInt().go();
    }

    void go() {
        System.out.println(doSruff());
    }

    
    public int doSruff() {
        return 3;
    }

}
