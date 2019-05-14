/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structural.decarator;

/**
 *
 * @author Denys.Prokopiuk
 */
public class SimplePhone implements SomePhone {

    @Override
    public int phonePrice() {
        return 100;
    }

    @Override
    public String phoneName() {
        return "SimplePhone";
    }
    
}
