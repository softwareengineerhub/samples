/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch10.concurrency.sample01.myrecursiveaction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyRecursiveAction extends RecursiveAction {

    private int workload;
    private String name;

    public MyRecursiveAction(int workload, String name) {
        this.workload = workload;
        this.name = name;
    }

    @Override
    protected void compute() {
        System.out.println(name + "@Start" + hashCode() + ". This task is started. workload=" + workload + "; thread=" + Thread.currentThread().getName());
        if (workload > 10) {
            System.out.println(name + "@Fork" + hashCode() + ".makes SUBTASKS. workload=" + workload + "; thread=" + Thread.currentThread().getName());
            delay(10000);
            List<MyRecursiveAction> subtasks = initSubTasks();
            for (MyRecursiveAction subtask : subtasks) {
                subtask.fork();
            }
            for (MyRecursiveAction subtask : subtasks) {
                subtask.join();
            }
            System.out.println(name + "@Join" + hashCode() + ".finish SUBTASKS. workload=" + workload + "; thread=" + Thread.currentThread().getName());
        } else {
            System.out.println(name + hashCode() + ". This task is finished. NO subtasks workload=" + workload + "; thread=" + Thread.currentThread().getName());
        }
    }

    private List<MyRecursiveAction> initSubTasks() {
        List<MyRecursiveAction> list = new ArrayList();
        MyRecursiveAction subtask1 = new MyRecursiveAction(workload / 2, name + "\t");
        MyRecursiveAction subtask2 = new MyRecursiveAction(workload / 2, name + "\t");
        list.add(subtask1);
        list.add(subtask2);
        return list;
    }

    private void delay(long milleseconds) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= milleseconds) {
        }
    }

}
