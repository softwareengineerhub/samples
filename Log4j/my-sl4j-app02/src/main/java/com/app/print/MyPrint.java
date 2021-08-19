package com.app.print;

import com.app.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MyPrint {
    private static final Logger LOG = LoggerFactory.getLogger("app-log");

    public void printData(Map map){
        for(Object key: map.keySet()){
            LOG.info(" map: {}={}", key, map.get(key));
        }
        LOG.error("make some error to file");
    }

    public void printError(Exception ex){
        LoggerFactory.getLogger("error-app-log").error(ex.getMessage(), ex);
    }
}
