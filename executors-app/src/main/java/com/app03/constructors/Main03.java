package com.app03.constructors;

import java.util.concurrent.Executors;

public class Main03 {

    public static void main(String[] args) {
        Executors.newFixedThreadPool(1);
        //return new ThreadPoolExecutor(nThreads, nThreads,
        //                                      0L, TimeUnit.MILLISECONDS,
        //                                      new LinkedBlockingQueue<Runnable>());
    }

}
