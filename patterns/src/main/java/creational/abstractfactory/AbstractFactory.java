/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational.abstractfactory;

import creational.abstractfactory.Company;
import creational.abstractfactory.Department;

/**
 *
 * @author prokopiukd
 */
public abstract class AbstractFactory {

    public abstract Company getCompany(int type);

    public abstract Department getDepartment(int type);

}
