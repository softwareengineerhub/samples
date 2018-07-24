/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.cql.sample.highload;

import com.app.ch01.cql.sample.User;


/**
 *
 * @author denys.prokopiuk
 */
public class DataGenerator {

    public User initUser(){
        User user = new User();
        user.setContent("Content"+Thread.currentThread().getId()+";time="+System.currentTimeMillis());
        user.setLogin("Login"+Thread.currentThread().getId()+";time="+System.currentTimeMillis());
        user.setRole("role");
        return user;
    }
    
}
