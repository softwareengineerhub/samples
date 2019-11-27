/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.completablefuture.app04.compose;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * @author DProkopiuk
 */
public class ChainSample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> res1 = CompletableFuture.supplyAsync(() -> "Hello "+Thread.currentThread().getName());
        CompletableFuture<String> res2 = res1.thenCompose(new Function<String, CompletionStage<String>>() {

            @Override
            public CompletionStage<String> apply(String t) {
                return CompletableFuture.supplyAsync(new Supplier<String>() {

                    @Override
                    public String get() {
                        return t + ";next"+Thread.currentThread().getName()+"; ";
                    }
                });
            }

        });
        String res = res2.get();
        System.out.println("res="+res);
    }

}
