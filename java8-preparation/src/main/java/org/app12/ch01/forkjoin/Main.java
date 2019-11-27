/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app12.ch01.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 *
 * @author dprokopiuk
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] data = {1, 2, 3, 4, 5, 6};
        ForkJoinPool pool = new ForkJoinPool(4);
        ForkJoinTask<Integer> task = pool.submit(new MyRecursiveTask(data, ""));
        int res = task.get();
        System.out.println("res=" + res);
    }

}
