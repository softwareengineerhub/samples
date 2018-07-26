/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.highload;

/**
 *
 * @author denys.prokopiuk
 */
public class UserMetrics {

    private long amountOfRestCalls;
    private double totalTimeForRestCallsAmount;

    public long getAmountOfRestCalls() {
        return amountOfRestCalls;
    }

    public void setAmountOfRestCalls(long amountOfRestCalls) {
        this.amountOfRestCalls = amountOfRestCalls;
    }

    public double getTotalTimeForRestCallsAmount() {
        return totalTimeForRestCallsAmount;
    }

    public void setTotalTimeForRestCallsAmount(double totalTimeForRestCallsAmount) {
        this.totalTimeForRestCallsAmount = totalTimeForRestCallsAmount;
    }

}
