/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app12.ch01.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author dprokopiuk
 */
public class MyRecursiveTask extends RecursiveTask<Integer> {

    private int[] data;
    private String s;

    public MyRecursiveTask(int[] data, String s) {
        this.data = data;
        this.s=s;
    }

    @Override
    protected Integer compute() {
        System.out.println(s+Arrays.toString(data)+"; "+Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        if(data.length>1){
            List<MyRecursiveTask> subtasks = initSubtasks();
            for(MyRecursiveTask item: subtasks){
                item.fork();
            }
            int sum = 0;
            for(MyRecursiveTask item: subtasks){
                sum+=item.join();
            }
            return sum;
        }else{
            if(data.length==1){
                return data[0];
            }
            return 0;
        }
    }

    private List<MyRecursiveTask> initSubtasks() {
        List<MyRecursiveTask> list = new ArrayList<>();
        list.add(new MyRecursiveTask(Arrays.copyOfRange(data, 0, data.length / 2), s+"\t"));
        list.add(new MyRecursiveTask(Arrays.copyOfRange(data, data.length / 2, data.length), s+"\t"));
        return list;
    }

}
