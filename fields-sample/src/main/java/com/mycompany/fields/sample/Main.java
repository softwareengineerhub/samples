/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fields.sample;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        Child parent = new Child();
       // parent.setAge(1);
        //parent.setName("Name1");
        
        System.out.println("age="+parent.getAge());
        System.out.println("name="+parent.getName());
        
        Method m = parent.getClass().getSuperclass().getMethod("getName");
        Object res = m.invoke(parent);
        System.out.println("res="+res);
        m = parent.getClass().getSuperclass().asSubclass(Parent.class).getMethod("getName");
        res=m.invoke(parent);
        System.out.println("res="+res);
        System.out.println("--------------------------------------------");
        
      //  Field field = Class.forName("com.mycompany.fields.sample.Parent").getSuperclass().getField("name");
          Field field = Class.forName("com.mycompany.fields.sample.Child").getSuperclass().getDeclaredField("name");
          field.setAccessible(true);
          res = field.get(parent);
        System.out.println("res="+res);
        
        
    }
    
    
}
