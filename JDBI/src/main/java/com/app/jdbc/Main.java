/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.jdbc;

import java.util.List;

/**
 *
 * @author prokopiukd
 */
public class Main {

    public static void main(String[] args) {
        DAO dao = new DAOImpl();
        List<Person> persons = dao.getAll();
        for (Person p : persons) {
            System.out.println(p);
        }
    }

}
