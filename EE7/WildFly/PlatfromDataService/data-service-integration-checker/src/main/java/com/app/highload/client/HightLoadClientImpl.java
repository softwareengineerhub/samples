/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.highload.client;

import java.util.HashMap;
import java.util.Map;
import com.app.common.client.APIClient;
import com.app.common.client.APIClientImpl;
import com.app.highload.UserMetrics;
import com.app.highload.UserThread;

/**
 *
 * @author denys.prokopiuk
 */
public class HightLoadClientImpl implements HightLoadClient {

    private Thread[] users;
    private Map<String, UserMetrics> userMetricsData;

    public HightLoadClientImpl() {
        userMetricsData = new HashMap();
    }

    @Override
    public void initUsers(int amountOfUsers, long delayBetweenCalls, long durationOfWork, long delayBeforeStart, String url) {
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<delayBeforeStart){            
        }
        users = new Thread[amountOfUsers];
        for (int i = 0; i < users.length; i++) {
            APIClient client = new APIClientImpl(url);
            UserMetrics userMetrics = new UserMetrics();
            users[i] = new UserThread(client, delayBetweenCalls, durationOfWork, userMetrics);
            userMetricsData.put(users[i].getName(), userMetrics);
        }
    }

    @Override
    public void startCalls() {
        for (Thread t : users) {
            t.start();
        }
    }

    @Override
    public Map<String, UserMetrics> getUserMetrics() {
        return userMetricsData;
    }

}
