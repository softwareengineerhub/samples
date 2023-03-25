package com.book.ch01.lambda.app02.funct;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class MainFunction {

    public static void main(String[] args) {
        Function<String, Integer> f1 = (s)->s.length();
        int res=f1.apply("www");
        System.out.println("res="+res);
        System.out.println("--------------------");

        Function<String, Integer> f2 = f1.andThen(s->s++);
        int res2=f2.apply("www");
        System.out.println("res2="+res2);
        System.out.println("--------------------");

        Function<String, Integer> f3 = f1.compose(s->"TTTTTTTT");
        int res3=f3.apply("www");
        System.out.println("res3="+res3);
        System.out.println("--------------------");

        Function<String, String> f4 = s->s+"A";
        Function<String, String> f5 = f4.andThen(s->s+"B");
        Function<String, String> f6 = f4.compose(s->s+"B");
        System.out.println("f5="+f5.apply("Data"));
        System.out.println("f6="+f6.apply("Data"));
        System.out.println("--------------------");

        UnaryOperator<String> q = s->s.toUpperCase();
        System.out.println(q.apply("www"));
        BinaryOperator<String> q2 = (x,y)->x.toUpperCase()+y.toLowerCase();
        System.out.println(q2.apply("www", "TTT"));


        System.out.println("--------------------");
        Map<String, String> map = new HashMap();
        String val = map.compute("a", (x,y)->{return x+y;});
        System.out.println(map);
        System.out.println("val="+val);

        String val2 = map.compute("a", (x,y)->{return x+y;});
        System.out.println(map);
        System.out.println("val2="+val2);

        String ggg = map.putIfAbsent("a","WWW");
        System.out.println("ggg="+ggg);
        System.out.println("map="+map);









    }

}
