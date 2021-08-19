package com.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            logger.debug("MyDebug");
            logger.info("Hello, {}", "Denys");
            String s = null;
            s.toCharArray();
        }catch (Exception ex){
            logger.error("Exception", ex);
        }


    }

}
