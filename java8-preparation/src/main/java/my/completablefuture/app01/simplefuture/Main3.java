/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.completablefuture.app01.simplefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author DProkopiuk
 */
public class Main3 {

    public static void main(String[] args) {
        try {
            Main3 main3 = new Main3();
            Future<String> res = main3.calculateAsync();
            String str = res.get();
            System.out.println(str + "qqq");
        } catch (Exception ex) {
            System.out.println("@After get()");
        }
    }

    public Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.cancel(false);
            System.out.println("@Do after");
            Thread.sleep(1500);
            return null;
        });

        return completableFuture;
    }

}
