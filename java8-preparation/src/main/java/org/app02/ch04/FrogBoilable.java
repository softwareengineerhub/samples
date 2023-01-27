/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app02.ch04;

/**
 *
 * @author dprokopiuk
 */
public interface FrogBoilable {

    static int getCtoF(int cTemp) {
        return (cTemp * 9 / 5) + 32;
    }

    default String hop() {
        return "hopping";
    }
    
}
