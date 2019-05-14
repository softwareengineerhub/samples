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
public class PhoneB extends SomePhoneDecorator {

    public PhoneB(SomePhone somePhone) {
        super(somePhone);
    }

    @Override
    public String phoneName() {
        return super.phoneName() + "; PhoneB";
    }

    @Override
    public int phonePrice() {
        return super.phonePrice() + 50;
    }

}
