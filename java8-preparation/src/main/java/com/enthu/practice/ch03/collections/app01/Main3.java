package com.enthu.practice.ch03.collections.app01;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main3 {

    public static void main(String[] args) {
        Deque<Integer> d = new ArrayDeque<>();
        d.push(1);
        d.offerLast(2);
        d.push(3);



        //System.out.println(d.poll());
        //System.out.println(d.pollFirst());
        System.out.println("d.peekFirst()="+d.peekFirst());
        System.out.println(d);
        System.out.println("d.removeLast()="+d.removeLast());
        System.out.println(d);
        System.out.println("d.pop()="+d.pop());
        System.out.println(d);
    }

}
