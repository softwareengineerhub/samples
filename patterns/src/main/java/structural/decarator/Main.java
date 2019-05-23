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
public class Main {

    public static void main(String[] args) {
        SomePhone somePhoneA = new PhoneA(new SimplePhone());
        String name = somePhoneA.phoneName();
        int price = somePhoneA.phonePrice();
        System.out.println("name=" + name);
        System.out.println("price=" + price);
        System.out.println("-----------------------------");
        
        SomePhone somePhoneB = new PhoneB(new SimplePhone());
        name = somePhoneB.phoneName();
        price = somePhoneB.phonePrice();
        System.out.println("name=" + name);
        System.out.println("price=" + price);
        System.out.println("-----------------------------");
    }

}
