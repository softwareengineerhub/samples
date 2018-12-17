package com.app;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger infoLogger = Logger.getLogger("info");
        //finest==30
        infoLogger.setLevel(Level.FINE);

        infoLogger.log(Level.INFO, "Hello info");
        infoLogger.log(Level.FINEST, "Hello finest");
        infoLogger.log(Level.FINE, "Hello fine");
        infoLogger.log(Level.SEVERE, "Hello severe");
        infoLogger.log(Level.WARNING, "Hello warning");
        infoLogger.log(Level.ALL, "Hello all");
        infoLogger.log(Level.CONFIG, "Hello config");
        infoLogger.log(Level.OFF, "Hello off");

        Map set = new TreeMap();

        set.put(Level.INFO.intValue(), Level.INFO);
        set.put(Level.FINEST.intValue(), Level.FINEST);
        set.put(Level.FINE.intValue(), Level.FINE);
        set.put(Level.SEVERE.intValue(), Level.SEVERE);
        set.put(Level.WARNING.intValue(), Level.WARNING);
        set.put(Level.ALL.intValue(), Level.ALL);
        set.put(Level.CONFIG.intValue(), Level.CONFIG);
        set.put(Level.OFF.intValue(), Level.OFF);

        for(Object key:set.keySet() ){
            System.out.println(key+"="+set.get(key));
        }

    }

}
