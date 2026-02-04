/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simpleprogrammer.actions;

import com.opensymphony.xwork2.Action;

/**
 *
 * @author admin
 */
public class TutorialAction implements Action {
    //private String failure;
    private String success;
    
    
    @Override
    public String execute(){
        System.out.println("TutorialAction.execute()");
        success =  "success";
        return "success";
        
        //failure = "Test";
        //return "failure";
    }

    /*public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }*/

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    
    
    
    
}
