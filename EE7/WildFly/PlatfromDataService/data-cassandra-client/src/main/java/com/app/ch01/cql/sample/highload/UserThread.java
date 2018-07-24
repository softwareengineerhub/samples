/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.cql.sample.highload;

import com.app.ch01.cql.sample.DAO;
import com.app.ch01.cql.sample.User;

/**
 *
 * @author denys.prokopiuk
 */
public class UserThread extends Thread {

    private DAO client;
    private DataGenerator dataGenerator;
    private long delayBetweenCalls;
    private long durationOfWork;
    private long counter;
    private double sum;

    public UserThread(DAO client, DataGenerator dataGenerator, long delayBetweenCalls, long durationOfWork) {
        this.client = client;
        this.dataGenerator = dataGenerator;
        this.delayBetweenCalls = delayBetweenCalls;
        this.durationOfWork = durationOfWork;
    }

    @Override
    public void run() {
        User user = dataGenerator.initUser();
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= durationOfWork) {
            long callStart = System.currentTimeMillis();
            client.create(user);
            counter++;
            sum += System.currentTimeMillis() - callStart;            
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
