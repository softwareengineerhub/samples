package com.app04.forkjoin.action;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        //ForkJoinPool pool = ForkJoinPool.commonPool();
        ForkJoinPool pool = new ForkJoinPool(1);
        pool.invoke(new MyAction(16, ""));
    }

}
