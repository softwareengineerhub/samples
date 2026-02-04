package org.example.references.soft;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class MySoftReferences2 {

    public static void main(String[] args) throws Exception {
        List<SoftReference> list = null;
        try {
            list = createStringList(90);
            System.gc();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        //Thread.sleep(1000);
        //byte[] res = softReference.get(s);
        System.out.println("-----------size=--------"+list.size());
        for(int i=0;i<list.size();i++){
            SoftReference softReference = list.get(i);
            System.out.println(i+"="+ softReference.get());
        }
    }

    private static List<SoftReference> createStringList(int n){
        List list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new SoftReference<>(new byte[1024*1024]));
        }
        return list;
    }

}
