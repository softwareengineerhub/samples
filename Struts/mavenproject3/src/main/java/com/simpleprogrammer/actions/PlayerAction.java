/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simpleprogrammer.actions;

import com.opensymphony.xwork2.Action;
import com.simpleprogrammer.service.PlayerFinderService;

/**
 *
 * @author admin
 */
public class PlayerAction implements Action {
    private String result;
    
    
    @Override
    public String execute(){
        System.out.println("TutorialAction.execute()");
        PlayerFinderService playerFinderService = new PlayerFinderService();
        String tmp = playerFinderService.getBestSite();
        System.out.println(" tmp="+ tmp);
        result =  tmp;
        return "success";
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    
    
    
    
}
