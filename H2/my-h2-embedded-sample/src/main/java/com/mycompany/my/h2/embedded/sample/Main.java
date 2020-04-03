/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.h2.embedded.sample;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    public static void main(String[] args) {
        Dao dao = new DaoImpl();
        dao.dropSchema();
        dao.initSchema();
        dao.clear();
        int size = dao.size();
        System.out.println("size="+size);
        dao.addAll(initPersons(10));
        size = dao.size();
        System.out.println("size="+size);
        Person candidate = new Person();
        candidate.setAge(1);
        candidate.setName("Name0Update");
        dao.update(0, candidate);
        List<Person> persons =  dao.readAll();
        for(Person p: persons){
            System.out.println(p);
        }
        dao.remove("Name0Update");
        size = dao.size();
        System.out.println("size="+size);
        candidate = new Person();
        candidate.setAge(0);
        candidate.setName("Name0");
        dao.add(candidate);
        size = dao.size();
        System.out.println("size="+size);
        persons =  dao.readAll();
        for(Person p: persons){
            System.out.println(p);
        }
       
    }
    
    private static List<Person> initPersons(int n){
        List<Person> list = new ArrayList();
        for(int i=0;i<n;i++){
            Person person = new Person();
            person.setAge(i);
            person.setName("Name"+i);
            list.add(person);
        }
        return list;
    }
    
}
