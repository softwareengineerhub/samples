/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.highload.client;

import java.util.Map;
import com.app.highload.UserMetrics;

/**
 *
 * @author denys.prokopiuk
 */
public interface HightLoadClient {

    public void initUsers(int amountOfUsers, long delayBetweenCalls, long durationOfWork, long delayBeforeStart, String servicePath);

    public void startCalls();

    public Map<String, UserMetrics> getUserMetrics();
}
