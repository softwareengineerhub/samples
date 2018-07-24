/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.loading;

import com.app.model.Attributes;
import com.app.model.DataMessage;
import com.app.model.Person;
/**
 *
 * @author denys.prokopiuk
 */
public class DataGenerator {

    public DataMessage initApiMessage() {
        Attributes attributes = new Attributes();
        attributes.setStatus("status1");
        attributes.setType("type1");
        Person person = new Person();
        person.setAge(1);
        person.setName("Name1");

        DataMessage dataMessage = new DataMessage();
        dataMessage.setVersion("version1");
        dataMessage.setPerson(person);
        dataMessage.setAttributes(attributes);

        return dataMessage;
    }

}
