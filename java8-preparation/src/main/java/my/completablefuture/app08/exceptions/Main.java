/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.completablefuture.app08.exceptions;

import java.util.concurrent.CompletableFuture;

/**
 *
 * @author DProkopiuk
 */
public class Main {

    public static void main(String[] args) {
        String name = null;

        CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s,t)->{
            System.out.println("s="+s);
            System.out.println("t="+t);
            return "";
        });
    }

}
