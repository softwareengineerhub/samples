package com.app04.forkjoin.task;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(1);
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MyTask myTask = new MyTask(data, "");
        int sum = pool.invoke(myTask);
        System.out.println("sum="+sum);
    }

}
