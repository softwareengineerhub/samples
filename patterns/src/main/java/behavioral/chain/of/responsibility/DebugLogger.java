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
public class DebugLogger extends Logger {

    public DebugLogger() {
        this.levels = Levels.DEBUG;
    }

    @Override
    public void displayLogInfo(String msg) {
        System.out.println("DEBUG: " + msg);
    }

}
