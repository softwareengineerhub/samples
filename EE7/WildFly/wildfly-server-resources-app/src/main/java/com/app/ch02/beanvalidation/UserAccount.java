/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch02.beanvalidation;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author denys.prokopiuk
 */
public class UserAccount {

    @NotNull
    private String name;
    @NotNull
    private String mail;    
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserAccount{" + "name=" + name + ", mail=" + mail + ", age=" + age + '}';
    }

}
