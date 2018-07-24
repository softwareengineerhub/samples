/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.starter;

import com.app.highloadclient.HightLoadClientImpl;
import com.app.highloadclient.HightLoadClient;
import com.app.client.ApiClientImpl;
import com.app.client.ApiClient;
import com.app.model.DataMessage;
import com.app.service.loading.DataGenerator;

/**
 *
 * @author denys.prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        //  putHighLoad();
        put();
       //get();
    }

    public static void put() {
        ApiClient client = new ApiClientImpl("http://127.0.0.1:8080/data-service-api/api/cassandra");
        DataGenerator dataGenerator = new DataGenerator();
        DataMessage message = dataGenerator.initApiMessage();
        int status = client.save(message);
        System.out.println("status="+status);
    }
    
    
    public static void get() {
        ApiClient client = new ApiClientImpl("http://localhost:8080/data-service-api/api/cassandra");
        DataMessage message = client.get();
        System.out.println(message);
    }
    
    public static void putHighLoad() {
        HightLoadClient hightLoadClient = new HightLoadClientImpl();
        hightLoadClient.initUsers(1000, 0, 60000, "http://127.0.0.1:8080/data-service-api/api/cassandra", new DataGenerator());
        hightLoadClient.startCalls();
    }

}
