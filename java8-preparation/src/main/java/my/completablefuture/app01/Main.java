/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.completablefuture.app01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.Function;

/**
 *
 * @author DProkopiuk ForkJoinPool.commonPool()
 */
public class Main {    
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> "Text");
        cf = cf.thenCompose((item)->{return item+"qqq";});
        cf = cf.thenCompose((item)->{return item+"tttt";});
        Object res = cf.get();
        System.out.println("res="+res);
    }
    
    
    public static void main7(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture.supplyAsync(() -> "").thenRun(() -> {
            System.out.println("COMPLETED!!!");
        }).get();
    }
    
    public static void main6(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture.supplyAsync(() -> "").thenAccept(s -> {
            System.out.println("COMPLETED!!!");
        }).get();
    }
    
    public static void main5(String[] args) throws InterruptedException, ExecutionException {        
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture cf2 = cf.thenApply(t -> "qqq" + t);
        System.out.println(cf2.get());
        System.out.println(cf.hashCode());
        System.out.println(cf2.hashCode());
    }    
    
    public static void main4(String[] args) throws InterruptedException, ExecutionException {        
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> "Hello");
        System.out.println(cf.get());
    }
    
    public static void main3(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> "Hello");
        System.out.println(cf.get());
    }
    
    public static void main2(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture cf = CompletableFuture.completedFuture("MyValue");
        System.out.println(cf.get());
    }
    
    public static void main1(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture cf = new CompletableFuture();
        
        Executors.newFixedThreadPool(10).submit(() -> {
            cf.complete("Hello CompletableFuture");
        });
        
        Object res = cf.get();
        System.out.println("res=" + res);
    }
    
}
