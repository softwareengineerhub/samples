/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.generics.collections.sample3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    /*public static void main(String[] args) {
        Map<Object, ? extends Object> m = new LinkedHashMap<Object, Object>();
        m.put("1", new ArrayList());    //1
        m.put(1, new Object());    //2
        m.put(1.0, "Hello");     //3
        System.out.println(m);
    }*/

    public static void main2(String[] args) {
        Map<Object, ? super ArrayList> m = new LinkedHashMap<Object, ArrayList>();
        m.put("1", new ArrayList());    //1
//        m.put(1, new Object());    //2
        //       m.put(1.0, "Hello");     //3
        System.out.println(m);
    }

}
