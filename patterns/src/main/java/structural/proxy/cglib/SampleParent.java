/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structural.proxy.cglib;

/**
 *
 * @author asusadmin
 */
public class SampleParent {

    public String m1(){
        System.out.println("SimpleParent.m1()");
        return "mym1";
    }
    
    public String m2(){
        System.out.println("SimpleParent.m2()");
        return "mym2";
    }
    
}
