/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.stateless.remote;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author denys.prokopiuk
 */
public class MyInterceptor {
    
    @AroundInvoke
    public Object process(InvocationContext ctx) throws Exception {
        System.out.println("@Before call");
        Object res = ctx.proceed();
        System.out.println("@After call");
        return res;
    }
    
}
