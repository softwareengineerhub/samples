/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simpleprogrammer.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author asusadmin
 */
public class HelloAction2 extends ActionSupport {

    private String greeting;

    
    @Override
    public String execute() {
        ActionContext ctx = null;
        greeting = "Hello Struts 2";
        System.out.println("Greeting="+greeting+"; hash="+hashCode());
        return "success";
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

}
