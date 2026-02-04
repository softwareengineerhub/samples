package org.example.iterator.fast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyFailFast {

    public static void main(String[] args) {
        //Collections.sy
        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        /*for(String s: list){
            if("b".equals(s)){
                list.add("d");
            }
        }*/

        Iterator<String> itr = list.iterator();
        /*while(itr.hasNext()){
            if("b".equals(itr.next())){
                list.add("d");
            }
        }*/

        /*while(itr.hasNext()){
            if("b".equals(itr.next())){
                itr.remove();
            }
        }*/


        /*ListIterator itr = list.listIterator();
        while(itr.hasNext()){

        }*/
    }

}