package org.example.references.soft;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class MySoftReferences {

    public static void main(String[] args) throws Exception {
        byte[] data = createData(100);

        SoftReference<byte[]> softReference = new SoftReference<>(data);
        try {
            createStringList(9000);
            System.gc();
        }catch (Throwable ex){
            ex.printStackTrace();
        }
       // Thread.sleep(1000);
        byte[] res = softReference.get();
        System.out.println("-----------res--------");
        for(byte b: res){
            System.out.println(b);
        }
    }

    private static List<byte[]> createStringList(int n){
        List<byte[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new byte[1024*1024]);
        }
        return list;
    }

    private static byte[] createData(int n) {
        byte[] data = new byte[n];
        for(int i=0;i<n;i++) {
            data[i]=(byte)i;
        }
        return data;
    }

}
