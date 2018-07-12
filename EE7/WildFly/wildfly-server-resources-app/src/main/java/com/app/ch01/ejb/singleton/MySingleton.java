/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.singleton;

import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author denys.prokopiuk
 */
@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@AccessTimeout(value = 5, unit = TimeUnit.SECONDS)
public class MySingleton {

    @PostConstruct
    private void init() {
        System.out.println("MySingleton. init()");
    }

    @Lock(LockType.READ)
    public String getName() {
        makeDelay(10000);
        return "Denis";
    }

    @Lock(LockType.WRITE)
    public String getGender() {
        System.out.println("getGender().hashCode="+hashCode());
        makeDelay(60000);
        return "Male";
    }
    
    public String setGender() {
        return "Male";
    }

    @PreDestroy
    public void destroy() {
        System.out.println("MySingleton. destroy()");
    }
    
    private void makeDelay(long delay){
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<=delay){            
        }
    }

}
