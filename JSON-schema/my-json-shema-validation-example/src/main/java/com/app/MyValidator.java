/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author asusadmin
 */
public class MyValidator {

    public void validateValid() {
        JSONObject jsonSchema = new JSONObject(new JSONTokener(getClass().getResourceAsStream("/schema.json")));
        JSONObject jsonSubject = new JSONObject(new JSONTokener(getClass().getResourceAsStream("/personValid.json")));
        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
    }
    
    public void validateInvalid() {
        JSONObject jsonSchema = new JSONObject(new JSONTokener(getClass().getResourceAsStream("/schema.json")));
        JSONObject jsonSubject = new JSONObject(new JSONTokener(getClass().getResourceAsStream("/personInvalid.json")));
        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
    }

}
