package com.app04.forkjoin.task;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class MyTask extends RecursiveTask<Integer> {
    private int[] data;
    private String depth;

    public MyTask(int[] data, String depth) {
        this.data = data;
        this.depth = depth;
    }

    @Override
    protected Integer compute() {
        System.out.println(depth+"Task with data started="+ Arrays.toString(data));
        if(data.length==1){
            System.out.println(depth+"Task with data finished="+ Arrays.toString(data)+"; result="+data[0]);
            return data[0];
        }
        int[] subData1 = new int[data.length/2];
        int[] subData2 = new int[data.length - data.length/2];
        System.arraycopy(data, 0, subData1, 0, subData1.length);
        System.arraycopy(data, data.length/2, subData2, 0, subData2.length);
        MyTask subTask1 = new MyTask(subData1, "\t"+depth);
        MyTask subTask2 = new MyTask(subData2,"\t"+depth);
        subTask1.fork();
        subTask2.fork();
        int sum1 = subTask1.join();
        int sum2 = subTask2.join();
        int sum = sum1+sum2;
        System.out.println(depth+"Task with data finished="+ Arrays.toString(data)+"; result="+sum);
        return sum;
    }

}
