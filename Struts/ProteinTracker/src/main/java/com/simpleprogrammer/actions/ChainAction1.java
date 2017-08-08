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
public class ChainAction1 implements Action {

    @Override
    public String execute() throws Exception {
        System.out.println("Chain action1");
        return "success";
    }

}
