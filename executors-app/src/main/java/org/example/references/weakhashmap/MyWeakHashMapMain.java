package org.example.references.weakhashmap;

import java.util.WeakHashMap;

public class MyWeakHashMapMain {

    //keys of WeakHashMap are WeakReferences
    public static void main(String[] args) throws InterruptedException {
        WeakHashMap<MyKey, MyValue> map = new WeakHashMap<>();
        map.put(new MyKey(1), new MyValue("a"));
        map.put(new MyKey(2), new MyValue("b"));
        map.put(new MyKey(3), new MyValue("c"));
        System.gc();
        //Thread.sleep(1000);
        System.out.println(map);
    }

}
