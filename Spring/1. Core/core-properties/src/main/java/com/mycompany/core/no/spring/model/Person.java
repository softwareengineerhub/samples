/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.core.no.spring.model;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author prokopiukd
 */
public class Person {
    @Value("${data.firstname}")
    private String name;
    @Value("${data.lastname}")
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", surname=" + surname + '}';
    }
    
    
}
