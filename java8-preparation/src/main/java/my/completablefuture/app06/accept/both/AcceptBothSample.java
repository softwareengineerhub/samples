/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.completablefuture.app06.accept.both;

import java.util.concurrent.CompletableFuture;

/**
 *
 * @author DProkopiuk
 * 
 * Compose is better for chain
 */
public class AcceptBothSample {
    
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(()-> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(()-> " World"), (s1,s2)->System.out.println(s1+"; "+ s2));
    }
    
}
