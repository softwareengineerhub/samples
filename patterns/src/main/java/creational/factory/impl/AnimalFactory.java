/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational.factory.impl;

import creational.factory.Animal;
import creational.factory.Cat;
import creational.factory.Dog;
import creational.factory.Duck;

/**
 *
 * @author prokopiukd
 */
public class AnimalFactory {

    public Animal getAnimal(int type) {
        switch (type) {
            case 0:
                return new Cat();
            case 1:
                return new Dog();
            case 2:
                return new Duck();
            default:
                throw new IllegalArgumentException("Incorrect type: " + type);
        }
    }

}
