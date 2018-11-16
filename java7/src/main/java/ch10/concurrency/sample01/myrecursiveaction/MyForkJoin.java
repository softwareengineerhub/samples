/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch10.concurrency.sample01.myrecursiveaction;

import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyForkJoin {

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        forkJoinPool.invoke(new MyRecursiveAction(54, ""));
    }

}
