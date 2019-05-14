/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structural.proxy.jdkdynamics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    
    public static void main(String[] args) {
        Class[] classes = new Class[]{MyFootballer.class, MyBasketballer.class};
        MyPlayer myPlayer = new MyPlayer();
        InvocationHandler myProxy = new MyProxy(myPlayer);
        Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), classes, myProxy);
        MyFootballer f = (MyFootballer) proxy;
        f.playFootball(10);
        System.out.println("-------------------");        
        MyBasketballer b = (MyBasketballer) proxy;
        b.playBasketball();
    }

}
