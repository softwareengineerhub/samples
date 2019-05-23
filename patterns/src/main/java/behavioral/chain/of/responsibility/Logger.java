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
public abstract class Logger {

    protected Levels levels;
    protected Logger nextLevelLogger;

    public void setNextLevelLogger(Logger nextLevelLogger) {
        this.nextLevelLogger = nextLevelLogger;
    }

    public void logMessage(Levels levels, String msg) {
        if (this.levels.ordinal() <= levels.ordinal()) {
            displayLogInfo(msg);
        }
        if (nextLevelLogger != null) {
            nextLevelLogger.logMessage(levels, msg);
        }
    }

    public abstract void displayLogInfo(String msg);

}
