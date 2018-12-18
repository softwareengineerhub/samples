/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.generics.collections.sample4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main03 {

    public static void main(String[] args) {
        List<MyParent04> list = new ArrayList<>();
        list.add(new MyChild04A());
        list.add(new MyChild04B());
        System.out.println(list);
    }

    public void produce(List<? super MyParent04> list) {
        //list.add("");
        list.add(new MyChild04A());
        list.add(new MyChild04B());
        list.add(new MyParent04());
    }

    public void consume(List<? extends MyParent04> list) {
        //list.add("");
        MyParent04 res = list.get(0);
    }

}
