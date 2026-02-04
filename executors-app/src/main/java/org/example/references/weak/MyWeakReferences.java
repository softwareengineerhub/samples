package org.example.references.weak;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MyWeakReferences {

    public static void main(String[] args) throws InterruptedException {
        List<WeakReference> list = createList(1000);

        System.gc();
        Thread.sleep(1000);
        for(int i=0;i<list.size();i++){
            System.out.println(i+"="+list.get(i));
        }
    }

    private static List<WeakReference> createList(int n){
        List<WeakReference> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new WeakReference(new byte[1024*1024]));
        }
        return list;
    }
}
