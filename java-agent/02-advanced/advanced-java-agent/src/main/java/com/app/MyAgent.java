package com.app;

import java.lang.instrument.Instrumentation;

public class MyAgent {

    public static void premain(String agentArgument, Instrumentation instrumentation){
        System.out.println("----Start of Agent-----------");
        CounterTransformer counterTransformer = new CounterTransformer();
        instrumentation.addTransformer(counterTransformer);
        System.out.println("total count of classes="+counterTransformer.getCount());
    }
}
