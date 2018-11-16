/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch10.concurrency.sample01.mysumcount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MySumRecursiveTask extends RecursiveTask<Integer> {

    private int[] data;
    private String name;

    public MySumRecursiveTask(int[] data, String name) {
        this.data = data;
        this.name = name;
    }

    @Override
    protected Integer compute() {
        System.out.println(name + "@Start" + hashCode() + ". This task is started. data=" + Arrays.toString(data) + "; thread=" + Thread.currentThread().getName());
        if(data.length>2){
            delay(5000);
            System.out.println(name + "@ForkStart" + hashCode() + ".makes SUBTASKS. data=" + Arrays.toString(data) + "; thread=" + Thread.currentThread().getName());
            delay(5000);
            List<MySumRecursiveTask> subTasks = initTasks();
            for(MySumRecursiveTask task: subTasks){
                task.fork();
            }
            delay(5000);
            System.out.println(name + "@ForkFinish" + hashCode() + ".makes SUBTASKS. data=" + Arrays.toString(data) + "; thread=" + Thread.currentThread().getName());
            int res=0;
            System.out.println(name + "@JoinStart" + hashCode() + ".finish SUBTASKS. workload=" + Arrays.toString(data) + "; thread=" + Thread.currentThread().getName());
            for(MySumRecursiveTask task: subTasks){
                res+=task.join();
            }
            System.out.println(name + "@JoinFinish" + hashCode() + ".finish SUBTASKS. workload=" + Arrays.toString(data) + "; thread=" + Thread.currentThread().getName());
            return res;
        } else {
            System.out.println(name + hashCode() + ". This task is finished. NO subtasks workload=" + Arrays.toString(data) + "; thread=" + Thread.currentThread().getName());
            return sum(data);
        }
    }
    
    
    
    private List<MySumRecursiveTask> initTasks(){
        List<MySumRecursiveTask> list = new ArrayList<>();
        list.add(new MySumRecursiveTask(Arrays.copyOfRange(data, 0, data.length/2), name+"\t"));
        list.add(new MySumRecursiveTask(Arrays.copyOfRange(data, data.length/2, data.length), name+"\t"));
        return list;
    }
    
    private int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    
    private void delay(long milleseconds) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= milleseconds) {
        }
    }


}
