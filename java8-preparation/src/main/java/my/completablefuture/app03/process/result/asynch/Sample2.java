/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.completablefuture.app03.process.result.asynch;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

/**
 *
 * @author DProkopiuk
 */

//No Future chains
public class Sample2 {
    
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<Void> completableFuture2 = completableFuture.thenAccept(new Consumer<String>(){
            
            @Override
            public void accept(String t) {
                System.out.println("res: "+t);
            }
            
        });
        completableFuture2.get();
//        System.out.println("res="+res);
        
    }
    
}
