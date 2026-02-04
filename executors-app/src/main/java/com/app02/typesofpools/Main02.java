package com.app02.typesofpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main02 {

    public static void main(String[] args) {
        Executors.newFixedThreadPool(1);
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(4);
        Executors.newSingleThreadExecutor();

    }

}
