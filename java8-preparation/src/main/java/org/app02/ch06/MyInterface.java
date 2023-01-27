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
public interface MyInterface {

    default int doStuff() {
        return 42;
    }

}
