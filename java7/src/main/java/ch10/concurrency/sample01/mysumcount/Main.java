/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch10.concurrency.sample01.mysumcount;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        RecursiveTask<Integer> rootTask = new MySumRecursiveTask(data, "");
        int sum = forkJoinPool.invoke(rootTask);
        System.out.println("sum=" + sum);
    }

}
