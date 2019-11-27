/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app10.grouping;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author asusadmin
 */
public class MainStandartCollectors {
    
    public static void main(String[] args) {
        MyPhone p1 = new MyPhone(1, "Name1");
        MyPhone p2 = new MyPhone(2, "Name2");
        MyPhone p3 = new MyPhone(3, "Name3");
        MyPhone p4 = new MyPhone(4, "Name4");
        MyPhone p5 = new MyPhone(1, "Name5");
        Map<Integer, Long> map = Stream.of(p1, p2, p3, p4, p5).collect(Collectors.groupingBy(MyPhone::getId, Collectors.counting()));
        System.out.println("---------------------------------Counting-----------------------------------");
        System.out.println(map);
        
        Map<Integer, IntSummaryStatistics> map2 = Stream.of(p1, p2, p3, p4, p5).collect(Collectors.groupingBy(MyPhone::getId, Collectors.summarizingInt(new ToIntFunction<MyPhone>(){
            
            @Override
            public int applyAsInt(MyPhone value) {
                return value.getName().length();
            }
            
            
            
        })));
        System.out.println("---------------------------------Summarizing-----------------------------------");
        System.out.println(map2);
        
        Map<Integer, IntSummaryStatistics> map3 = Stream.of(p1, p2, p3, p4, p5).collect(Collectors.groupingBy(MyPhone::getId, Collectors.summarizingInt((MyPhone value) -> value.getName().length())));
        System.out.println("---------------------------------Summarizing 2-----------------------------------");
        System.out.println(map3);
        
        
       Map<Integer, Optional<MyPhone>> map4 =  Stream.of(p1, p2, p3, p4, p5).collect(Collectors.groupingBy(MyPhone::getId, Collectors.maxBy(new Comparator<MyPhone>(){
            
            @Override
            public int compare(MyPhone ph1, MyPhone ph2) {
                return ph1.getId()-ph2.getId();
            }
            
        })));
        System.out.println("---------------------------------maxBy-----------------------------------");
        System.out.println(map4);
        
        
        Map<Integer, Optional<MyPhone>> map5 =  Stream.of(p1, p2, p3, p4, p5).collect(Collectors.groupingBy(MyPhone::getId, Collectors.maxBy((MyPhone ph1, MyPhone ph2) -> ph1.getId()-ph2.getId())));
        System.out.println("---------------------------------maxBy2-----------------------------------");
        System.out.println(map5);
        
        
        System.out.println("-----------------------------reducing---------------------------------------------");
        Map<Integer, Object> map6 = Stream.of(p1, p2, p3, p4, p5).collect(Collectors.groupingBy(MyPhone::getId, Collectors.reducing(0, new BinaryOperator<Object>(){
            
            @Override
            public Object apply(Object t, Object u) {
                //MyPhone a = (MyPhone) t;
                //MyPhone b = (MyPhone) u;
                
                //Integer
                System.out.println(t.getClass());
                return t.hashCode()+u.hashCode();
            }
            
        })));
        System.out.println(map6);
        
        
        System.out.println("-----------------------------reducing2---------------------------------------------");
        Map<String, Object> map7 = Stream.of(p1, p2, p3, p4, p5).collect(Collectors.groupingBy(MyPhone::getName, Collectors.reducing("", new BinaryOperator<Object>(){
            
            @Override
            public Object apply(Object t, Object u) {
                //MyPhone a = (MyPhone) t;
                //MyPhone b = (MyPhone) u;
                
                //Integer
                System.out.println(t.getClass());
                return t.hashCode()+u.hashCode();
            }
            
        })));
        System.out.println(map7);
    }
    
}
