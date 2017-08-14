/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutorialspoint.ch03;

/**
 *
 * @author prokopiukd
 */
public class PersonService {

    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public double makeAction(double a, double b) {
        return personDao.makeAction(a, b);
    }
}
