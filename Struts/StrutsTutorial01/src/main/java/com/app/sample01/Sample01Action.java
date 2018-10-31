/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sample01;

import com.opensymphony.xwork2.Action;

/**
 *
 * @author asusadmin
 */
public class Sample01Action implements Action {
    private String message;
    
    @Override
    public String execute() throws Exception {
        setMessage("Sample01Action response");
        return "success";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
