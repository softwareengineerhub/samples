/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structural.proxy.pattern;

/**
 *
 * @author Denys.Prokopiuk
 */
public class BMW implements Car {

    @Override
    public void drive() {
        System.out.println("Drive BMW");
    }
    
}
