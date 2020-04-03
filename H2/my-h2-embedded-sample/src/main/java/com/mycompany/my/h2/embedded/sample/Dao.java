/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.h2.embedded.sample;

import java.util.List;

/**
 *
 * @author asusadmin
 */
public interface Dao {
    
    public void initSchema();
    
    public void dropSchema();
    
    public void clear();
    
    public int size();
    
    public List<Person> readAll();
    
    public void remove(String name);
    
    public void add(Person person);
    
    public void addAll(List<Person> persons);
    
    public void update(int age, Person candidate);
    
}
