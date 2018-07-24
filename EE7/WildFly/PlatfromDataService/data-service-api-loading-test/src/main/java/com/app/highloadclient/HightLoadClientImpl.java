/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.highloadclient;

import com.app.client.ApiClientImpl;
import com.app.service.loading.DataGenerator;
import com.app.service.loading.UserThread;
import com.app.client.ApiClient;

/**
 *
 * @author denys.prokopiuk
 */
public class HightLoadClientImpl implements HightLoadClient {

    private Thread[] users;

    @Override
    public void initUsers(int amountOfUsers, long delayBetweenCalls, long durationOfWork, String servicePath, DataGenerator dataGenerator) {
        users = new Thread[amountOfUsers];
        for (int i = 0; i < users.length; i++) {
            ApiClient client = new ApiClientImpl(servicePath);
            users[i] = new UserThread(client, dataGenerator, delayBetweenCalls, durationOfWork);
        }
    }

    @Override
    public void startCalls() {
        for(Thread t: users){
            t.start();
        }
    }

}
