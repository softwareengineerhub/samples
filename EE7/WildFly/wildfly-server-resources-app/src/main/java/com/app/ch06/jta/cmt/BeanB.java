/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch06.jta.cmt;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless
public class BeanB {
    
    @Resource
    private EJBContext context;
    
    public void m(){
        System.out.println("EJBContext="+context);
    }
    
}
