/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch06.jta.bmt;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.UserTransaction;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class BeanA {
    @Resource
    private UserTransaction ut;
    
    public void process(){
        
    }
}
