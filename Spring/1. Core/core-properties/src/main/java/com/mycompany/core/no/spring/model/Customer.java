/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.core.no.spring.model;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author denys
 */
public class Customer {

    @Value("${data.firstname}")
    private String firstname;
    @Value("${data.lastname}")
    private String lastname;

    public Customer() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Customer{" + "firstname=" + firstname + ", lastname=" + lastname + '}';
    }

}
