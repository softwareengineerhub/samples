/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository.mongo;

import com.app.model.DataMessage;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.bson.Document;
import com.app.repository.DataRepository;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless(name = "mongoDataRepository")
public class MongoRepositoryImpl implements DataRepository {

    @EJB
    private MongoDataSource mongoDataSource;
    @Inject
    private MongoDataConvertor mongoDataConvertor;

    @Override
    public void persist(DataMessage dataMessage) {
        MongoDatabase mongoDatabase = mongoDataSource.getMongoDatabase();
        MongoCollection<Document> collection = mongoDatabase.getCollection("api_message");
        Document document = mongoDataConvertor.convert(dataMessage);
        collection.insertOne(document);
    }

}
