/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behavioral.chain.of.responsibility;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
 
    public static void main(String[] args) {
        Logger logger = new InfoLogger();
        logger.logMessage(Levels.INFO, "info-info");
        logger.logMessage(Levels.DEBUG, "info-debug");
        logger.logMessage(Levels.ERROR, "info-error");
        System.out.println("----------------------------");
        logger = new DebugLogger();
        logger.logMessage(Levels.INFO, "debug-info");
        logger.logMessage(Levels.DEBUG, "debug-debug");
        logger.logMessage(Levels.ERROR, "debug-error");
        System.out.println("----------------------------");
        logger = new ErrorLogger();
        logger.logMessage(Levels.INFO, "debug-info");
        logger.logMessage(Levels.DEBUG, "debug-debug");
        logger.logMessage(Levels.ERROR, "debug-error");
    }
    
}
