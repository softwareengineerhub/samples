package com.book.ch01.lambda.app02.funct;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class MainPredicate {

    public static void main(String[] args) {
        Predicate<Integer> p1 = i -> i > 0;
        boolean res = p1.test(10);
        Predicate<Integer> p2 = p1.negate();
        boolean res2 = p2.test(10);
        System.out.println("res=" + res);
        System.out.println("res2=" + res2);
        System.out.println("---------------");
        Predicate<Integer> p3 = p1.or(i -> i % 2 == 0);
        //boolean res3 = p3.test(10);
        //System.out.println("res3=" + res3);
        boolean res3 = p3.test(-10);
        System.out.println("res3=" + res3);

        Predicate<Integer> p4 = p1.and(i -> i % 2 == 0);
        boolean res4 = p4.test(-10);
        System.out.println("res4=" + res4);


        System.out.println("----------");
        String s = new String("a");
        Predicate<String> p5= Predicate.isEqual("a");
        System.out.println(p5.test(s));

        System.out.println("----------");
        BiPredicate<String, Integer> bp = (x,y)->x.length()==y;
        boolean res6 = bp.test("test", 4);
        System.out.println("res6="+res6);
    }

}
