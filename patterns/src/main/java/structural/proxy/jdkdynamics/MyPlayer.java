/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structural.proxy.jdkdynamics;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyPlayer implements MyFootballer, MyBasketballer {

    @Override
    public void playFootball(int number) {
        System.out.println("football player # "+number);
    }

    @Override
    public void playBasketball() {
        System.out.println("basketball player");
    }
    
}
