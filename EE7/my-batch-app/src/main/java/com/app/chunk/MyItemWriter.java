package com.app.chunk;

import java.util.List;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;

@Named(value="MyItemWriter")
public class MyItemWriter extends AbstractItemWriter {

    @Override
    public void writeItems(List<Object> items) throws Exception {
        System.out.println("MyItemWriter.items:"+items);
    }

}
