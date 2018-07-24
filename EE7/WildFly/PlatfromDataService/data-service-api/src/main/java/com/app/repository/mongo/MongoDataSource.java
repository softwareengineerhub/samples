/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

/**
 *
 * @author denys.prokopiuk
 */
@Singleton
public class MongoDataSource {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    @PostConstruct
    private void init() {
        mongoClient = new MongoClient("localhost", 27017);
        mongoDatabase = mongoClient.getDatabase("data_db");
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    @PreDestroy
    public void destroy() {
        if (mongoDatabase != null) {
           // mongoDatabase.drop();
        }
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

}
