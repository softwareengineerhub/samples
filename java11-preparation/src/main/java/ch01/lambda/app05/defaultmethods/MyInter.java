/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app05.defaultmethods;

/**
 *
 * @author DProkopiuk
 */
public interface MyInter {

    long getId();

    default String getName() {
        return "SomeName";
    }
    
    default void doAction(){
        System.out.println("doAction()");
    }

}
