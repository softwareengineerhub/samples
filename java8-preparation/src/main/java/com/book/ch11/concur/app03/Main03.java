package com.book.ch11.concur.app03;

import java.util.concurrent.*;

public class Main03 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        tpe.setCorePoolSize(4);
        tpe.setMaximumPoolSize(8);

        Future<String> res = executorService.submit(() -> "Test");
        try {
            String text = res.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }

}
