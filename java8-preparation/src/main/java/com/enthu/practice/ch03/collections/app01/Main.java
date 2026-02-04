package com.enthu.practice.ch03.collections.app01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Deque<Integer> d = new ArrayDeque<>();

        d.push(1);
        d.push(2);
        d.push(3);
        System.out.println(d);

        System.out.println(d.poll());
        //System.out.println(d.pollFirst());
        //System.out.println(d.pollLast());
        System.out.println(d);
        
        System.out.println("------------------------");
        Deque<Integer> queue = new ArrayDeque<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("queue="+queue);
        System.out.println(queue.poll());
        
        System.out.println("------------------------");
        Deque<Integer> queue2 = new ArrayDeque<>();
        queue2.add(1);
        queue2.add(2);
        queue2.add(3);
        System.out.println("queue2="+queue2);
        System.out.println(queue2.poll());
        
        
        System.out.println("------------------------");
        Deque<Integer> queue3 = new ArrayDeque<>();
        queue3.add(1);
        queue3.add(2);
        queue3.add(3);
        System.out.println("queue3="+queue3);
        System.out.println(queue3.peek());
        System.out.println(queue3.peek());
        
        System.out.println("------------------------");
        Deque<Integer> queue4 = new ArrayDeque<>();
        queue4.add(1);
        queue4.add(2);
        queue4.add(3);
        System.out.println("queue4="+queue4);
        System.out.println(queue4.pop());
        System.out.println(queue4);
        
        //List<MyData> list = new ArrayList();
        //Collections.sort(list);
        TreeSet<MyData> set = new TreeSet();
        MyData myData = new MyData();
        set.add(myData);
        
    }
    
    private static class MyData {
        public int value;

        //@Override
        public int compareTo(MyData o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
