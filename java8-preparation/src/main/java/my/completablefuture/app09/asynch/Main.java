/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.completablefuture.app09.asynch;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author DProkopiuk
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> completableFuture2 = completableFuture.thenApplyAsync(s -> s + " World");
        String res = completableFuture2.get();
        System.out.println(res);
    }

}
