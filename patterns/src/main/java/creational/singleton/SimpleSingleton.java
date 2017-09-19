/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational.singleton;

/**
 *
 * @author prokopiukd
 */
public class SimpleSingleton {

    private static SimpleSingleton instance;

    private SimpleSingleton() {
    }

    public static synchronized SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton();
        }
        return instance;
    }

}
