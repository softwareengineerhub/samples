/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app09.collecting;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author asusadmin
 */
public class Main2CollectingToMaps {
    
    public static void main(String[] args) {
        
        MyPerson p1 = new MyPerson(1, "Name1");
        MyPerson p2 = new MyPerson(2, "Name2");
        MyPerson p3 = new MyPerson(3, "Name3");
        MyPerson p4 = new MyPerson(4, "Name4");
        Map<Integer, String> map = Stream.of(p1, p2, p3, p4).collect(Collectors.toMap(MyPerson::getId, MyPerson::getName));
        for(int key: map.keySet()){
            System.out.println(key+"="+map.get(key));
        }
        System.out.println("-------------------------------------------------");
        Map<Integer, MyPerson> map2 = Stream.of(p1, p2, p3, p4).collect(Collectors.toMap(MyPerson::getId, Function.identity()));
        Map<Integer, MyPerson> map3 = Stream.of(p1, p2, p3, p4).collect(Collectors.toConcurrentMap(MyPerson::getId, Function.identity()));
        
        
    }
    
}
