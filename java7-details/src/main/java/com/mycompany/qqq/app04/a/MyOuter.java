/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qqq.app04.a;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyOuter {

    {
        MyInner inner = new MyInner();
    }

    public static class MyInner {

        static {
            System.out.println("MyInner.static()");
        }

        {
            System.out.println("\tMyInner.init()");
        }

        private MyInner() {
            System.out.println("\t\tMyInner.constructor");
        }

        public static MyInner getInner() {
            return new MyInner();
        }

    }

    public class MyInner2 {

        {
            System.out.println("\tMyInner2.init()");
        }

        protected MyInner2() {
            System.out.println("\t\tMyInner2.constructor");
        }

    }
    
    
    public static class MyInner3 {

        {
            System.out.println("\tMyInner3.init()");
        }

        public MyInner3() {
            System.out.println("\t\tMyInner3.constructor");
        }

    }

}
