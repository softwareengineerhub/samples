/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.highload.client.template;

import java.util.Map;
import com.app.highload.UserMetrics;
import com.app.highload.client.HightLoadClient;
import com.app.highload.client.HightLoadClientImpl;

/**
 *
 * @author denys.prokopiuk
 */
public class CheckerTemplateStringImpl implements CheckerTemplate {

    @Override
    public String initUsers(int amountOfUsers, long delayBetweenCalls, long durationOfWork, long delayBeforeStart, String url) {
        try {
            StringBuilder sb = new StringBuilder();
            HightLoadClient hightLoadClient = new HightLoadClientImpl();
            long timeToWork = 60000;
            long delayBeforeCall = 5000;
            hightLoadClient.initUsers(amountOfUsers, 0, timeToWork, delayBeforeCall, url);
            hightLoadClient.startCalls();
            System.out.println("Process is STARTED");
            Thread.sleep(timeToWork + 10000);
            System.out.println("Process is FINISHED");
            Map<String, UserMetrics> userMetricsData = hightLoadClient.getUserMetrics();
            long sumOfCalls = 0;
            double sumOfTotalTime = 0;
            double maxOfTime = 0;
            for (String key : userMetricsData.keySet()) {
                UserMetrics userMetrics = userMetricsData.get(key);
                long calls = userMetrics.getAmountOfRestCalls();
                double totalTime = userMetrics.getTotalTimeForRestCallsAmount();
                String line = String.format("count=%s; time=%s; avg duration of 1 call=%s; calls-per-second=%s", calls, totalTime, totalTime / calls, calls / (timeToWork / 1000));
                sb.append(line);
                sb.append("\n");

                if (totalTime > maxOfTime) {
                    maxOfTime = totalTime;
                }
                sumOfTotalTime += totalTime;
                sumOfCalls += calls;
                sumOfTotalTime += totalTime;
            }
            sb.append("---------------------------------------------------------------------------------------------------------------------------------------------------");
            sb.append("\n");
            String result = String.format("count=%s; maxtime=%s; avg duration of 1 call=%s; calls-per-second=%s", sumOfCalls, maxOfTime, (sumOfTotalTime / amountOfUsers) / sumOfCalls, sumOfCalls / (maxOfTime / 1000));
            sb.append(result);
            return sb.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
