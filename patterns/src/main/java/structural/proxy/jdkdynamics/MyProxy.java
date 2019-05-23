/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structural.proxy.jdkdynamics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyProxy implements InvocationHandler {

    private Object target;

    public MyProxy(Object target) {
        this.target = target;
    }
   
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("args: "+Arrays.toString(args));     
        System.out.println("method: "+method);    
        return method.invoke(target, args);
    }

}
