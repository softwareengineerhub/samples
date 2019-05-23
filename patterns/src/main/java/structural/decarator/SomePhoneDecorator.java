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
public abstract class SomePhoneDecorator implements SomePhone {

    private SomePhone somePhone;

    public SomePhoneDecorator(SomePhone somePhone) {
        this.somePhone = somePhone;
    }

    @Override
    public int phonePrice() {
        return somePhone.phonePrice();
    }

    @Override
    public String phoneName() {
        return somePhone.phoneName();
    }

}
