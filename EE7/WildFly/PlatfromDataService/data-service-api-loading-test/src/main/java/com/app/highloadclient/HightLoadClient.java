/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.highloadclient;

import com.app.service.loading.DataGenerator;

/**
 *
 * @author denys.prokopiuk
 */
public interface HightLoadClient {
    
    public void initUsers(int amountOfUsers, long delayBetweenCalls, long durationOfWork, String servicePath, DataGenerator dataGenerator);
    
    public void startCalls();
}
