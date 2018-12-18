/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.generics.collections.sample1;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main2 {
    
    
    public static void main(String[] args) {
        Queue queue = new ArrayBlockingQueue(10);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue);
        Object obj1 = queue.peek();
        System.out.println(obj1);
        Object obj2 = queue.poll();
        System.out.println(obj2);
    }
    
    
    public static void main1(String[] args) {
        Queue queue = new ArrayBlockingQueue(10);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue);
        for(Object item: queue){
            System.out.println(item);
        }
    }
    
    
    public static void main2(String[] args) {
        Queue queue = new ArrayBlockingQueue(10);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue);
        for(Object item: queue){
            System.out.println(item);
        }
    }
    
}
