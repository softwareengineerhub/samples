/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.highload.client.template;

import com.app.highload.UserMetrics;
import com.app.highload.client.HightLoadClient;
import com.app.highload.client.HightLoadClientImpl;
import java.util.Map;

/**
 *
 * @author denys.prokopiuk
 */
public class CheckerTemplateJSONImpl implements CheckerTemplate {

    @Override
    public String initUsers(int amountOfUsers, long delayBetweenCalls, long durationOfWork, long delayBeforeStart, String url) {
        try {
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

            StringBuilder jsonArrayBuilder = new StringBuilder();
            String userLine = "{\"count\":\"%s\", \"time\":\"%s\", \"avg_duration_of_1_call\":\"%s\", \"calls_per_second\":\"%s\"}";
            for (String key : userMetricsData.keySet()) {
                UserMetrics userMetrics = userMetricsData.get(key);
                long calls = userMetrics.getAmountOfRestCalls();
                double totalTime = userMetrics.getTotalTimeForRestCallsAmount();
                String line = String.format(userLine, calls, totalTime, totalTime / calls, calls / (timeToWork / 1000));
                jsonArrayBuilder.append(line);
                jsonArrayBuilder.append(",\n");
                if (totalTime > maxOfTime) {
                    maxOfTime = totalTime;
                }
                sumOfTotalTime += totalTime;
                sumOfCalls += calls;
                sumOfTotalTime += totalTime;
            }
            jsonArrayBuilder.deleteCharAt(jsonArrayBuilder.length() - 1);
            jsonArrayBuilder.deleteCharAt(jsonArrayBuilder.length() - 1);
            String resultLine = "{\n"
                    + "    \"data\": \"data1\",\n"
                    + "    \"user\": [\n"
                    + "       %s\n"
                    + "    ],\n"
                    + "    \"result\": {\"count\":\"%s\", \"maxtime\":\"%s\", \"avg_duration_of_1_call\":\"%s\", \"calls_per_second\":\"%s\"}\n"
                    + "}";

            String result = String.format(resultLine, jsonArrayBuilder.toString(), sumOfCalls, maxOfTime, (sumOfTotalTime / amountOfUsers) / sumOfCalls, sumOfCalls / (maxOfTime / 1000));
            return result;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
