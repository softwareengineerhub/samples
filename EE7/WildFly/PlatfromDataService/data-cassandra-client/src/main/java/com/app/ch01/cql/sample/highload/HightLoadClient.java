/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.cql.sample.highload;

import com.app.ch01.cql.sample.DAO;

/**
 *
 * @author denys.prokopiuk
 */
public interface HightLoadClient {
    
    public void initUsers(int amountOfUsers, long delayBetweenCalls, long durationOfWork, DAO dao, DataGenerator dataGenerator);
    
    public void startCalls();
}
