/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simpleprogrammer.actions;

import com.opensymphony.xwork2.Action;

/**
 *
 * @author denys
 */
public class ChainAction implements Action {

    //@Override
    //@org.apache.struts2.convention.annotation.Action("hi")
    public String execute() throws Exception {
        System.out.println("Chain action");
        return "do-next-action";
        //return "success";
    }

    /*    @Override
    @org.apache.struts2.convention.annotation.Action("hi")
    public String execute() throws Exception {
        System.out.println("Chain action");
        return "do-next-action";
    }*/
    
    public String doNextAction() throws Exception {
        System.out.println("Next action");
        return "hello";
    }

}
