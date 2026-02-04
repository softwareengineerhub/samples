package org.example.iterator.safe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyFailSafe {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        //Map<String, Integer> map = new HashMap<>();

        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        Iterator<String> itr = map.keySet().iterator();
        while(itr.hasNext()){
            if("b".equals(itr.next())){
                map.put("d", 4);
            }
        }

        System.out.println(map);
    }

}
