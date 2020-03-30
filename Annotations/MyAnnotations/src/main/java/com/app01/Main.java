/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    public static void main(String[] args) {
        MyAppEngine myAppEngine = new MyAppEngine();
        DataProcessor dataProcessor = new DataProcessor();
        myAppEngine.analyseDataProcessorAndInvoke(dataProcessor, new String[]{"doAction", "doAction2"});
    }
    
}
