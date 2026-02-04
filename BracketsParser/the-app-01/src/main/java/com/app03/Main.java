package com.app03;

public class Main {

    public static void main(String[] args) {
        SimpleResolver simpleResolver = new SimpleResolver();
        boolean result = simpleResolver.isSolution("2*x+5=17", 10);
        System.out.println("10 result="+result);

        result = simpleResolver.isSolution("2*x+5=17", 6);
        System.out.println("6 result="+result);
    }
}
