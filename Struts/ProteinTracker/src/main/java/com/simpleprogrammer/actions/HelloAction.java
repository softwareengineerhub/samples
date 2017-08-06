/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simpleprogrammer.actions;

import com.opensymphony.xwork2.Action;

/**
 *
 * @author prokopiukd
 */
public class HelloAction implements Action {

    private String greeting;

    @Override
    public String execute() throws Exception {
        greeting = "Hello Struts 2";
        return "success";
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

}
