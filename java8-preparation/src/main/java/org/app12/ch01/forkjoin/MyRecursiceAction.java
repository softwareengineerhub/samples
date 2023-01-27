/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app12.ch01.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author dprokopiuk
 */
public class MyRecursiceAction extends RecursiveAction {

    private String name;
    private int workload;

    public MyRecursiceAction(String name, int workload) {
        this.name = name;
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload > 2) {
            List<MyRecursiceAction> subtasks = initSubTasks();
            for (MyRecursiceAction item : subtasks) {
                item.fork();
            }
            for (MyRecursiceAction item : subtasks) {
                item.join();
            }
        } else {
            System.out.println("Task is finished");
        }
    }

    private List<MyRecursiceAction> initSubTasks() {
        List<MyRecursiceAction> list = new ArrayList();
        list.add(new MyRecursiceAction(name + ";subtask;\t", workload / 2));
        list.add(new MyRecursiceAction(name + ";subtask;\t", workload / 2));
        return list;
    }

}
