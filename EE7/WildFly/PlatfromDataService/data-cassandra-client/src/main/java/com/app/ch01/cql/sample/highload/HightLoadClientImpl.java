/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.cql.sample.highload;

import com.app.ch01.cql.sample.DAO;
import com.app.ch01.cql.sample.DAOImpl2;
import com.app.ch01.cql.sample.DAOImpl4;

/**
 *
 * @author denys.prokopiuk
 */
public class HightLoadClientImpl implements HightLoadClient {

    private Thread[] users;

    @Override
    public void initUsers(int amountOfUsers, long delayBetweenCalls, long durationOfWork, DAO dao, DataGenerator dataGenerator) {
        users = new Thread[amountOfUsers];        
        for (int i = 0; i < users.length; i++) {
            users[i] = new UserThread(dao, dataGenerator, delayBetweenCalls, durationOfWork);
        }
    }

    @Override
    public void startCalls() {
        for(Thread t: users){
            t.start();
        }
    }

}
