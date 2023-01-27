/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.completablefuture.app07.multiple.inparallel;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author DProkopiuk
 */
public class AllOfSample2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "A");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "B");
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "C");
        CompletableFuture<String> f4 = CompletableFuture.supplyAsync(() -> "D");
        CompletableFuture<String> f5 = CompletableFuture.supplyAsync(() -> "E");

        String combined = Stream.of(f1, f2, f3, f4, f5)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        System.out.println("combined: " + combined);
    }

}
