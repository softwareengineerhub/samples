/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository.mongo;

import com.app.model.DataMessage;
import com.app.model.Attributes;
import com.app.model.Person;
import java.util.HashMap;
import java.util.Map;
import org.bson.Document;

/**
 *
 * @author denys.prokopiuk
 */
public class MongoDataConvertor {

    public Document convert(DataMessage apiMessage) {
        Attributes attributes = apiMessage.getAttributes();
        Person person = apiMessage.getPerson();
        String version = apiMessage.getVersion();

        Map<String, Object> map = new HashMap<>();
        map.put("status", attributes.getStatus());
        map.put("type", attributes.getType());
        map.put("age", person.getAge());
        map.put("name", person.getName());
        map.put("version", version);

        Document doc = new Document(map);
        return doc;
    }
}
