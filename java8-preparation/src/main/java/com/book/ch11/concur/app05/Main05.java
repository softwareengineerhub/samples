package com.book.ch11.concur.app05;

import java.util.concurrent.ForkJoinPool;

public class Main05 {

    public static void main(String[] args) {
        ForkJoinPool.commonPool();
        new ForkJoinPool();
        new ForkJoinPool(10);
        int p = Runtime.getRuntime().availableProcessors();

    }

}
