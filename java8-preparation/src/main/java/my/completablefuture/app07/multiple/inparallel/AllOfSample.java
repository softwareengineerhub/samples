package my.completablefuture.app07.multiple.inparallel;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author DProkopiuk
 */
public class AllOfSample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "A");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "B");
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "C");
        CompletableFuture<String> f4 = CompletableFuture.supplyAsync(() -> "D");
        CompletableFuture<String> f5 = CompletableFuture.supplyAsync(() -> "E");

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(f1, f2, f3, f4, f5);
        completableFuture.get();
        System.out.println("--------------------------");
        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());
        System.out.println(f5.get());

    }

}
