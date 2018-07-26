/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.highload.client.template;

/**
 *
 * @author denys.prokopiuk
 */
public interface CheckerTemplate {

    public String initUsers(int amountOfUsers, long delayBetweenCalls, long durationOfWork, long delayBeforeStart, String url);

}
