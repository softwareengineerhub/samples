/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaplan.ch00.sample02;

import java.io.Closeable;
import java.io.IOException;

/**
 *
 * @author Denys.Prokopiuk
 * Closeable extends AutoCloseable
 */
public class MyCloseable implements Closeable {
    private String name;

    public MyCloseable(String name) {
        this.name = name;
    }
    
    @Override
    public void close() throws IOException {
        System.out.println("Close: name="+name);
        if(name.contains("2")){
            String s = null;
            s.toString();
        }
    }
    
}
