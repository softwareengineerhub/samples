package com.app.controllers;

import com.app.model.DataModel;
import com.app.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping(value = "/save")
    public void save(@RequestBody DataModel model) {

        System.out.println(model);
        dataService.save(model);
    }
}
