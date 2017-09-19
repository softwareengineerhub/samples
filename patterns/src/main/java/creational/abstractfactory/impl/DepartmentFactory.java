/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational.abstractfactory.impl;

import creational.abstractfactory.AbstractFactory;
import creational.abstractfactory.Company;
import creational.abstractfactory.Department;

/**
 *
 * @author prokopiukd
 */
public class DepartmentFactory extends AbstractFactory {

    @Override
    public Company getCompany(int type) {
        return null;
    }

    @Override
    public Department getDepartment(int type) {
        switch (type) {
            case 0:
                return null;
            default:
                throw new IllegalArgumentException("Incorrect type: " + type);
        }
    }

}
