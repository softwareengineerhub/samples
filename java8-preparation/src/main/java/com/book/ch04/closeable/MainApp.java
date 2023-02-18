package com.book.ch04.closeable;

public class MainApp {

    public static void main(String[] args) {
        try (MyAutoCloseable myAutoCloseable = new MyAutoCloseable();
             MyCloseable myCloseable = new MyCloseable();
        ) {
            System.out.println("INSIDE TRY");
        } catch (Exception ex) {
           // ex.printStackTrace();
            System.out.println("ex: "+ex.getMessage());
        } finally {
            System.out.println("finally");
        }
    }


}
