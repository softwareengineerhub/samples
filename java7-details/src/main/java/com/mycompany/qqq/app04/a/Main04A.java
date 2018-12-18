/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qqq.app04.a;

import com.mycompany.qqq.app04.a.MyOuter.MyInner;
import com.mycompany.qqq.app04.a.MyOuter.MyInner2;
import com.mycompany.qqq.app04.a.MyOuter.MyInner3;


/**
 *
 * @author Denys.Prokopiuk
 */
public class Main04A {

    public static void main(String[] args) {
        //MyInner inner = new MyOuter().new MyInner();
        MyInner inner = MyOuter.MyInner.getInner();
        MyInner2 inner2 = new MyOuter().new MyInner2();
        MyInner3 inner3 = new MyOuter.MyInner3();
        inner3 = new MyOuter.MyInner3();
    }

}
