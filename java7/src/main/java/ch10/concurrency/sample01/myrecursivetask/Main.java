/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch10.concurrency.sample01.myrecursivetask;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);        
        Object res=forkJoinPool.invoke(new MyRecursiveTask(54, "", "rootTask"));
        System.out.println("res="+res);
    }
            
    
}
