package com.enthu.practice.ch06.exceptions.app01;

public class Main06 {

    public static void main(String[] args) {
        try (MyAutocloseable m1 = new MyAutocloseable();
             MyAutocloseable2 m2 = new MyAutocloseable2()) {
            System.out.println("do action1");
            System.out.println("do action2");
            String s = null;
                    s.trim();
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("ex");
        } finally {
            System.out.println("finally");
        }

    }

}
