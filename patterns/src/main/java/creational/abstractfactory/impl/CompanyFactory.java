/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational.abstractfactory.impl;

import creational.abstractfactory.AbstractFactory;
import creational.abstractfactory.Company;
import creational.abstractfactory.CompanyA;
import creational.abstractfactory.CompanyB;
import creational.abstractfactory.CompanyC;
import creational.abstractfactory.Department;

/**
 *
 * @author prokopiukd
 */
public class CompanyFactory extends AbstractFactory {

    @Override
    public Company getCompany(int type) {
        switch (type) {
            case 0:
                return new CompanyA();
            case 1:
                return new CompanyB();
            case 2:
                return new CompanyC();
            default:
                throw new RuntimeException("Incorrect type: " + type);
        }
    }

    @Override
    public Department getDepartment(int type) {
        return null;
    }

}
