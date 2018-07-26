/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.highload.client.app;

import java.util.Map;
import com.app.highload.UserMetrics;
import com.app.highload.client.HightLoadClient;
import com.app.highload.client.HightLoadClientImpl;

/**
 *
 * @author denys.prokopiuk
 */
public class CheckerApp {

    public static void main(String[] args) throws InterruptedException {
        HightLoadClient hightLoadClient = new HightLoadClientImpl();
        long timeToWork = 60000;
        long delayBeforeCall = 5000;
        int users = 100;
        hightLoadClient.initUsers(users, 0, timeToWork, delayBeforeCall, "http://127.0.0.1:8080/data-service/api");
        hightLoadClient.startCalls();
        System.out.println("Process is STARTED");
        Thread.sleep(timeToWork + 10000);
        System.out.println("Process is FINISHED");
        Map<String, UserMetrics> userMetricsData = hightLoadClient.getUserMetrics();
        long sumOfCalls = 0;
        double maxOfTime = 0;
        double sumOfTotalTime = 0;
        for (String key : userMetricsData.keySet()) {
            UserMetrics userMetrics = userMetricsData.get(key);
            long calls = userMetrics.getAmountOfRestCalls();
            double totalTime = userMetrics.getTotalTimeForRestCallsAmount();
            System.out.println(String.format("count=%s; time=%s; avg duration of 1 call=%s; calls-per-second=%s", calls, totalTime, totalTime / calls, calls/(timeToWork/1000)));
            sumOfCalls+=calls;
            if(totalTime>maxOfTime){
                maxOfTime = totalTime;
            }
            sumOfTotalTime+=totalTime;
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("count=%s; maxtime=%s; avg duration of 1 call=%s; calls-per-second=%s", sumOfCalls, maxOfTime, (sumOfTotalTime/users) / sumOfCalls, sumOfCalls/(maxOfTime/1000)));
    }

}
