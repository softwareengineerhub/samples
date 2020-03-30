/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app03;

import com.app02.*;
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
public class Main3 {
    
    public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setIncompatibleImprovements(new Version("2.3.23"));
        cfg.setClassForTemplateLoading(Main3.class, "/");
        cfg.setDefaultEncoding("UTF-8");
        
        Template template = cfg.getTemplate("test3.ftl");

        Map<String, Object> templateData = new HashMap<>();

        Device d1 = new Device("TV", 1000);
        Device d2 = new Device("Phone", 2000);
        Device d3 = new Device("Computer", 3000);
        
        List<Device> deviceList = new ArrayList<>();
        deviceList.add(d1);
        deviceList.add(d2);
        deviceList.add(d3);        
        
        templateData.put("devices", deviceList);
        templateData.put("msg", "Today is a beautiful day");
        
        try (StringWriter out = new StringWriter()) {            
            template.process(templateData, out);
            System.out.println(out.getBuffer().toString());
            out.flush();
        }
    }
    
}
