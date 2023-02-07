package com.book.ch11.concur.app02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyCopyOnWriteList {

    public static void main(String[] args) {

        List<String> list = new CopyOnWriteArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Runnable r = ()-> {
            Iterator<String> itr = list.iterator();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.add("TTT");
            while(itr.hasNext()){
                String item = itr.next();
                System.out.println(item);
                if("b".equals(item)) {
                    //itr.remove();
                }
            }
        };
        Thread t1 = new Thread(r);
        t1.start();



    }

}
