package com.app.service;

import com.app.model.DataModel;
import com.app.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    private Repository repository;

    public void save(DataModel model) {
        repository.save(model);
    }
}
