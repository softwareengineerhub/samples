/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01;

import java.lang.reflect.Method;

/**
 *
 * @author asusadmin
 */
public class MyAppEngine {
    
    public void analyseDataProcessorAndInvoke(DataProcessor dataProcessor, String[] methodNamesToExecute){
            for(String methodName: methodNamesToExecute){
                 callMethod(dataProcessor, methodName);
            }
    }
    
    private void callMethod(DataProcessor dataProcessor, String methodName){
        try{
            Method m = dataProcessor.getClass().getDeclaredMethod(methodName);
            TypeA typeA = m.getDeclaredAnnotation(TypeA.class);
            if(typeA.enabled()){
                String message = typeA.message();
                System.out.println("call is enabled");
                System.out.println("message="+message);
                m.invoke(dataProcessor);
            }
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    
    
}
