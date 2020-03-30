/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02;

import com.app01.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author asusadmin
 */
public class Main2 {
    
    public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setIncompatibleImprovements(new Version("2.3.23"));
        cfg.setClassForTemplateLoading(Main2.class, "/");
        cfg.setDefaultEncoding("UTF-8");
        
        Template template = cfg.getTemplate("test2.ftl");

        Map<String, Object> templateData = new HashMap<>();

        Person p1 = new Person("Name1", 1);
        Person p2 = new Person("Name2", 2);
        Person p3 = new Person("Name3", 3);
        
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);        
        
        templateData.put("persons", personList);
        templateData.put("msg", "Today is a beautiful day");
        
        try (StringWriter out = new StringWriter()) {            
            template.process(templateData, out);
            System.out.println(out.getBuffer().toString());
            out.flush();
        }
    }
    
}
