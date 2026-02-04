/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch03.autocloseable.app01;

import java.io.IOException;

/**
 *
 * @author asusadmin
 */
public class SomeData implements AutoCloseable {
    private int id;

    public SomeData(int id) {
        System.out.println("Create with id="+id);
        this.id = id;
        if(id==1){
            throw new RuntimeException();
        }
    }
    
    
    public void close() throws IOException {
        System.out.println("Close app "+id);
        //throw new IOException();
    }
    
    public static void main(String[] args) throws Exception {
        try(SomeData sd1 = new SomeData(1);
                SomeData sd2 = new SomeData(2)){
            throw new RuntimeException();
        }
    }
    
}
