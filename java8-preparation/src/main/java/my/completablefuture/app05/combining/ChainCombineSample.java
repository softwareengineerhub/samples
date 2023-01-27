/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.completablefuture.app05.combining;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author DProkopiuk
 */
public class ChainCombineSample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String res = CompletableFuture
                .supplyAsync(() -> "Hello!!!")
                .thenCombine(CompletableFuture.supplyAsync(() -> " Word"), (s1, s2) -> s1 +"ttt"+ s2).get();
        System.out.println(res);
    }

}
