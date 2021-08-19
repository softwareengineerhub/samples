package com.app.service;

import com.app.print.MyPrint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MyService {
    private static final Logger LOG = LoggerFactory.getLogger("progress-log");
    private MyPrint myPrint;

    public MyService() {
        myPrint = new MyPrint();
    }

    public void doAction() {
        Map map = new HashMap();
        try {
            LOG.debug("doAction()---start");
            map.put("a", "A");
            String s = null;
            s.toCharArray();
            map.put("b", "B");
            map.put("c", "C");
            LOG.debug("doAction()---finish");
        }catch (Exception ex){
            myPrint.printError(ex);
        }finally {
            myPrint.printData(map);
        }
    }
}
