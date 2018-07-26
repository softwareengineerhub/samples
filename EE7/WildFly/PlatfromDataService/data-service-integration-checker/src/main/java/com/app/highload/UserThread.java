/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.highload;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.app.common.client.APIClient;

/**
 *
 * @author denys.prokopiuk
 */
public class UserThread extends Thread {

    private APIClient client;
    private long delayBetweenCalls;
    private long durationOfWork;
    private UserMetrics userMetrics;

    public UserThread(APIClient client, long delayBetweenCalls, long durationOfWork, UserMetrics userMetrics) {
        this.client = client;
        this.delayBetweenCalls = delayBetweenCalls;
        this.durationOfWork = durationOfWork;
        this.userMetrics = userMetrics;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= durationOfWork) {
            long callStart = System.currentTimeMillis();
            int status = client.put();
            userMetrics.setAmountOfRestCalls(userMetrics.getAmountOfRestCalls() + 1);
            userMetrics.setTotalTimeForRestCallsAmount(userMetrics.getTotalTimeForRestCallsAmount() + (System.currentTimeMillis() - callStart));
            if (status != 204) {
                throw new RuntimeException("Incorrect status: " + status);
            }
            long pauseStart = System.currentTimeMillis();
            while (System.currentTimeMillis() - pauseStart <= delayBetweenCalls) {
            }
        }       
    }

}
