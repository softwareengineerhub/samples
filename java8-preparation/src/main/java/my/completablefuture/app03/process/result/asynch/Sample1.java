/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.completablefuture.app03.process.result.asynch;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

/**
 *
 * @author DProkopiuk
 */

//Future Chain
public class Sample1 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> completableFuture2 = completableFuture.thenApply(new Function<String, String>(){
            
            @Override
            public String apply(String t) {
                return t+"QQQ";
            }
            
        });
        String res = completableFuture2.get();
        System.out.println("res="+res);
        
    }

}
