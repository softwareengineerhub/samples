package com.app.chunk;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;

@Named(value = "MyItemReader")
public class MyItemReader extends AbstractItemReader {
    private int i;
    
    @Override
    public Object readItem() throws Exception {
        System.out.println("Item reader");
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<=5000){            
        }
        if(i>10){
            return null;
        }
        return "StringItemSample#"+i++;
        // return "StringItemSample";
    }

}
