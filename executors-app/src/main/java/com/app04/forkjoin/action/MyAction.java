package com.app04.forkjoin.action;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MyAction extends RecursiveAction {
    private int count;
    private String depth;

    public MyAction(int count, String depth) {
        this.count = count;
        this.depth=depth;
    }

    @Override
    protected void compute() {
        if(count<=1){
            System.out.println(depth+"finish");
        } else {
            System.out.println(depth+"Splitting workLoad : " + count);
            MyAction action1 = new MyAction(count/2, depth+"\t");
            MyAction action2 = new MyAction(count-count/2, depth+"\t");
            action1.fork();
            action2.fork();
            //action1.join();
            //action2.join();
        }
    }

}
