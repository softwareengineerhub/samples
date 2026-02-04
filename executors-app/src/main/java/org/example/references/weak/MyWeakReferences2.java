package org.example.references.weak;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MyWeakReferences2 {

    public static void main(String[] args) throws InterruptedException {
        WeakReference<MyData> reference = new WeakReference(new MyData());
        //System.gc();
        Thread.sleep(1000);
        System.out.println(reference.get());
    }
}
