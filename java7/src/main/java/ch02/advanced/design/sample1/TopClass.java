/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.advanced.design.sample1;

/**
 *
 * @author Denys.Prokopiuk
 */
public class TopClass {

    public Inner inner1 = new Inner() {

        public void doA() {
            System.out.println("A2");
        }
    };

    public void doA() {
        inner1.doA();
    }
}

class Inner {

    int value;

    public void doA() {
        System.out.println("A1");
    }

}
