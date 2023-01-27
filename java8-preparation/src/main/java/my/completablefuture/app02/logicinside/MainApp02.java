/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.completablefuture.app02.logicinside;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DProkopiuk
 */
public class MainApp02 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {

            @Override
            public String get() {
                try {
                    Thread.sleep(3000);
                    return "A";
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        String res = future.get();
        System.out.println("res="+res);
        System.out.println("--------------------------------------------");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->{return "Result";});
        String res2 = future2.get();
        System.out.println("res2="+res2);
        System.out.println("--------------------------------------------");
        

    }

}
