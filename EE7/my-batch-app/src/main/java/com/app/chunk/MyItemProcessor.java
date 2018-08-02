package com.app.chunk;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named(value = "MyItemProcessor")
public class MyItemProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object item) throws Exception {
        System.out.println("###Item processor: item="+item);
        return item;
        // throw new UnsupportedOperationException("Not supported yet."); 
    }

}
