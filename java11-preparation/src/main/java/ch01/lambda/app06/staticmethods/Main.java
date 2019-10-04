/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app06.staticmethods;

/**
 *
 * @author DProkopiuk
 */
public class Main {

    public static void main(String[] args) {
        InterA.doAction();
        InterB.doAction();
        //InterC.doAction();
        ChildItem childItem = new ChildItem();
        //childItem.doAction();        
    }

}
