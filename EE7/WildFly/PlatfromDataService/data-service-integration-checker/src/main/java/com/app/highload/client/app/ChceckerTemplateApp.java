/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.highload.client.app;

import com.app.highload.client.template.CheckerTemplate;
import com.app.highload.client.template.CheckerTemplateJSONImpl;
import com.app.highload.client.template.CheckerTemplateStringImpl;

/**
 *
 * @author denys.prokopiuk
 */
public class ChceckerTemplateApp {
    
    public static void main(String[] args) {
        //CheckerTemplate checkerTemplate = new CheckerTemplateStringImpl();
        CheckerTemplate checkerTemplate = new CheckerTemplateJSONImpl();
        String result = checkerTemplate.initUsers(2, 0, 10000, 5, "http://127.0.0.1:8080/data-service/api");
        System.out.println(result);
    }
    
}
