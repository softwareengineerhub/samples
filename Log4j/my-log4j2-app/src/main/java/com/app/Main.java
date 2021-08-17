package com.app;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;

public class Main {

    public static void main(String[] args) {
        System.setProperty("level", "FATAL");

        System.setProperty("qqq", "a.log");
        Logger logger = Logger.getLogger("logA");
        logger.info("Welcome");

        System.setProperty("qqq", "b.log");
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        context.reconfigure();
        logger.info("Welcome2");
    }

}
