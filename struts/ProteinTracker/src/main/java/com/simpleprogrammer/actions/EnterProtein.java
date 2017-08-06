/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simpleprogrammer.actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Denis
 */
public class EnterProtein extends ActionSupport {

    private int enteredProtein;
    private static ProteinTrackingService proteinTrackingService = new ProteinTrackingService();

    @Override
    public String execute() throws Exception {
        proteinTrackingService.addProtein(enteredProtein);
        setEnteredProtein(proteinTrackingService.getSumOfProtein());
        return SUCCESS;
    }

    public int getEnteredProtein() {
        return enteredProtein;
    }

    public void setEnteredProtein(int enteredProtein) {
        this.enteredProtein = enteredProtein;
    }

    public String getGoalText() {
        return getText("goal.text","Default");
    }

}
