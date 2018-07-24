/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.loading;

import com.app.model.*;
import com.app.client.ApiClient;

/**
 *
 * @author denys.prokopiuk
 */
public class UserThread extends Thread {

    private ApiClient client;
    private DataGenerator dataGenerator;
    private long delayBetweenCalls;
    private long durationOfWork;
    private long counter;
    private double sum;

    public UserThread(ApiClient client, DataGenerator dataGenerator, long delayBetweenCalls, long durationOfWork) {
        this.client = client;
        this.dataGenerator = dataGenerator;
        this.delayBetweenCalls = delayBetweenCalls;
        this.durationOfWork = durationOfWork;
    }

    @Override
    public void run() {
        DataMessage dataMessage = dataGenerator.initApiMessage();
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= durationOfWork) {
            long callStart = System.currentTimeMillis();
            int status = client.save(dataMessage);
            counter++;
            sum += System.currentTimeMillis() - callStart;
            // System.out.println("status="+status);
            if (status != 204) {
                throw new RuntimeException("Incorrect status: " + status);
            }
            long pauseStart = System.currentTimeMillis();
            while (System.currentTimeMillis() - pauseStart <= delayBetweenCalls) {
            }
        }
        System.out.println("-----------------------------");
        System.out.println("amount of inserts: " + counter);
        System.out.println("SumOfTime: " + sum);
        System.out.println("Avg: " + (sum / counter));
        System.out.println("-----------------------------");
    }

}
