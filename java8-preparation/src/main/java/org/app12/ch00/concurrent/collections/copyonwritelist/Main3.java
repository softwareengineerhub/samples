/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app12.ch00.concurrent.collections.copyonwritelist;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author dprokopiuk
 */
public class Main3 {

    public static void main(String[] args) throws InterruptedException {
        //List<Integer> list = new ArrayList<>();
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Runnable r1 = () -> {
            try {
                Thread.sleep(2000);
                Iterator<Integer> itr = list.iterator();
                while (itr.hasNext()) {

                    Thread.sleep(1000);
                    int n = itr.next();
                    System.out.println(n+"; "+Thread.currentThread().getName());
                    if ((n + 2) % 2 == 0) {
                        list.add(100);
                    }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        };

        Runnable r2 = () -> {
            try {                
                Thread.sleep(5000);
                list.clear();
                Iterator<Integer> itr = list.iterator();
                while (itr.hasNext()) {
                    list.clear();
                    Thread.sleep(1000);
                    int n = itr.next();
                    System.out.println(n+"; "+Thread.currentThread().getName());
                    if (n == 4) {
                        list.remove(n);
                    }
                }
                //list.clear();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t2.start();
        t1.start();
        t1.join();
        t2.join();
        System.out.println("-----------------------------------");
        System.out.println(list);
    }

}
