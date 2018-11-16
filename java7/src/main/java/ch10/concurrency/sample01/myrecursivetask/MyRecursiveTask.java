/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch10.concurrency.sample01.myrecursivetask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyRecursiveTask extends RecursiveTask {

    private int workload;
    private String name;
    private String taskGlobalName;
    private static int taskNumber;

    public MyRecursiveTask(int workload, String name, String taskGlobalName) {
        this.workload = workload;
        this.name = name;
        this.taskGlobalName=taskGlobalName;
    }

    @Override
    protected Object compute() {
        List resultList = new ArrayList();
        if (workload >= 10) {
               List<MyRecursiveTask> subTasks = initSubTasks(); 
               for(MyRecursiveTask subTask:subTasks){
                   subTask.fork();
               }
               for(MyRecursiveTask subTask:subTasks){
                   Object subResult = subTask.join();
                   resultList.add(subResult);
               }
        } else {
                resultList.add("w="+workload+";globalName="+taskGlobalName);
        }
        return resultList;
    }

    private List<MyRecursiveTask> initSubTasks() {
        MyRecursiveTask myRecursiveTask1 = new MyRecursiveTask(workload / 2, name + "\t", ++taskNumber+"Task");
        MyRecursiveTask myRecursiveTask2 = new MyRecursiveTask(workload / 2, name + "\t", ++taskNumber+"Task");
        List<MyRecursiveTask> list = new ArrayList<>();
        list.add(myRecursiveTask1);
        list.add(myRecursiveTask2);
        return list;
    }

}
