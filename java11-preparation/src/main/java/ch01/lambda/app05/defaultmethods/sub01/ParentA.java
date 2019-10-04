/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app05.defaultmethods.sub01;

/**
 *
 * @author DProkopiuk
 */
public interface ParentA {

    default void m() {
        System.out.println("m().ParentA");
    }

}
