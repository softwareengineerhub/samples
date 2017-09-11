/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.my.app.streaming.cassandra;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prokopiukd
 */
public class Helper {

    public List<Person> initData(int n) {
        List<Person> persons = new ArrayList();
        for (int i = 0; i < n; i++) {
            Person p = new Person();
            p.setAge(i);
            p.setName("Name" + i);
            persons.add(p);
        }
        return persons;
    }

}
