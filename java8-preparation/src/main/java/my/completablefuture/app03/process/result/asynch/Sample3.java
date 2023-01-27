/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.completablefuture.app03.process.result.asynch;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DProkopiuk
 */
public class Sample3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sample3.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "Hello";
        });
        CompletableFuture<Void> completableFuture2 = completableFuture.thenRun(new Runnable() {

            @Override
            public void run() {
                System.out.println("Completed");
            }

        });
        completableFuture2.get();
//        System.out.println("res="+res);

    }

}
