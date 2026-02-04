package com.app01.pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main01 {

    public static void main(String[] args) {
        int count = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for(int i=0;i<100;i++){
            executorService.execute(()->{
                while(true){
                    try {
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(500);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }

                }
            });
        }

    }

}
