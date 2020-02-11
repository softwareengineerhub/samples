/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structural.proxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 *
 * @author asusadmin
 */
public class Main {

    public static void main(String[] args) {
        String resp = new SampleChild().m2();
        System.out.println(resp);
        System.out.println("-----------------");
        
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleParent.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] os, MethodProxy proxy) throws Throwable {
                if(method.getName().equals("m2")){
                    System.out.println("here");
                    return "@Before; "+proxy.invokeSuper(obj, os);
                } else {
                    return proxy.invokeSuper(obj, os);
                }
            }
        });
        
        String res = ((SampleParent)enhancer.create()).m2();
        System.out.println("res="+res);
    }
    
}
