package com.enthu.practice.ch03.collections.app01;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main2 {

    public static void main(String[] args) {
        Deque<Integer> d = new ArrayDeque<>();

        /*d.push(1);
        d.push(2);
        d.push(3);
        System.out.println(d);*/

        d.add(1);
        d.add(2);
        d.add(3);
        System.out.println(d);

        //System.out.println(d.poll());
        //System.out.println(d.pollFirst());
        System.out.println(d.pollLast());
        System.out.println(d);
    }

}
