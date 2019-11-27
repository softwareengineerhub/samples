/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.completablefuture.app01.simplefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 *
 * @author DProkopiuk
 */
public class Main2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Future<String> future = CompletableFuture.completedFuture("HelloResult");
        String res = future.get();
        System.out.println(res);
    }

}
