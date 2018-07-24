/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository.inmemory;

import com.app.model.DataMessage;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import com.app.repository.DataRepository;

/**
 *
 * @author denys.prokopiuk
 */
@Singleton(name = "inmemoryDataRepository")
public class InMemoryDataRepositoryImpl implements DataRepository {

    private List<DataMessage> messages;

    public InMemoryDataRepositoryImpl() {
        messages = new ArrayList();
    }

    @Override
    public void persist(DataMessage dataMessage) {
        messages.add(dataMessage);
    }

}
