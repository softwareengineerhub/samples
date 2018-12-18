/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qqq.app04.a.sub;

import com.mycompany.qqq.app04.a.MyOuter;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main04ASub {

    public static void main(String[] args) {
        //MyInner inner = new MyOuter().new MyInner();
        MyOuter.MyInner inner = MyOuter.MyInner.getInner();
        //MyOuter.MyInner2 inner2 = new MyOuter().new MyInner2();
    }

}
