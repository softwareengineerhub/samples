package com.book.ch01.lambda.app02.funct;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class MainSupplier {

    public static void main(String[] args) {
        Supplier<Integer> s = () -> 10;

        //not compiled
        /*Supplier<Integer> s = new Supplier(){

            public Integer get() {
                return 100;
            }
        };*/
        Integer res = s.get();
        int res2 = s.get();
        System.out.println("res=" + res);
        System.out.println("res2=" + res2);

        System.out.println("--------------------");

        //not compiled
        /*IntSupplier a = new IntSupplier() {
            @Override
            public Integer getAsInt() {
                return 0;
            }
        };*/

        IntSupplier a = new IntSupplier() {
            @Override
            public int getAsInt() {
                return 10;
            }
        };
        int res3 = a.getAsInt();
        System.out.println("res3="+res3);

        IntSupplier a2 = ()->20;
        int res4 = a2.getAsInt();
        System.out.println("res4="+res4);

        LongSupplier b = ()->10L;
        Long res5 = b.getAsLong();
        long res6 = b.getAsLong();
        DoubleSupplier c = ()->10;
        double res7 = c.getAsDouble();
        double res8 = c.getAsDouble();
    }
}
