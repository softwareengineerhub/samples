/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app02.ch01;

/**
 *
 * @author dprokopiuk
 */
public class Raptor extends Bird {

    static {
        System.out.println("r1 ");
    }

    public Raptor() {
        System.out.println("r2 ");
    }

    {
        System.out.println("r3 ");
    }

    static {
        System.out.println("r4 ");
    }
}
