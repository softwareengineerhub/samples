package com.app.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Example {

    private static final Logger LOG = LogManager.getLogger();

    public static void main(String... args){
        LOG.debug("This will be printed on debug");
        LOG.info("This will be printed on info");
        LOG.warn("This will be printed on warn");
        LOG.error("This will be printed on error");
        LOG.fatal("This will be printed on fatal");
        LOG.info("Appending string: {}.", "Hello, World");
      //  LOG.info("This will be printed on info");
      //  LOG.warn("This will be printed on warn");
    }
}
