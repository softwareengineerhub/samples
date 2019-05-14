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
public class CarProxy implements Car {

    private Car car = new BMW();

    @Override
    public void drive() {
        System.out.println("---------Proxy Drive Start----------------");
        car.drive();
        System.out.println("---------Proxy Drive Finish----------------");
    }

}
