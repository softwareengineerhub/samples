/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.exeprionsandassertions.sample02;

import java.sql.SQLException;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main06 {

    public static void main(String[] args) {
        MyProcessor processor = new MyProcessor();
        try {
            processor.doAcion1();
            processor.doAcion2();
        } catch (MyExceptionA | MyExceptionB e) {

        }
        System.out.println("------------------------------");
        try {
            processor.doAcion2();
            processor.doAcion1();
        } catch (MyExceptionA | MyExceptionB e) {

        }
        System.out.println("------------------------------");
        try {
            processor.doAcion2();
            processor.doAcion1();
        } catch (MyExceptionB | MyExceptionA e) {

        }
        
        System.out.println("------------------------------");
        try {
            processor.doAcion2();
            processor.doAcion1();
        } catch (Exception e) {

        }
        
        /*System.out.println("------------------------------");
        try {
            processor.doAcion2();
            processor.doAcion1();
        } catch (Exception | MyExceptionA e) {

        }*/
        
        /*System.out.println("------------------------------");
        try {
            processor.doAcion2();
            processor.doAcion1();
        } catch (Exception | MyExceptionA e) {

        }*/
        
        System.out.println("------------------------------");
        try {
            //processor.doAcion2();
            //processor.doAcion1();
        } catch (NullPointerException | AssertionError e) {

        }
    }

}
