package com.app.repository;

import com.app.model.DataModel;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class InMemoryRepositoryImpl implements Repository {

    private List<DataModel> dataModelList = new ArrayList<DataModel>();

    public void save(DataModel model) {
        dataModelList.add(model);
    }
}
