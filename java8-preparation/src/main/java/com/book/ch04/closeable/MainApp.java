package com.book.ch04.closeable;

import java.io.FileOutputStream;

public class MainApp {

    public static void main(String[] args) {
        try (MyAutoCloseable myAutoCloseable = new MyAutoCloseable();
             MyCloseable myCloseable = new MyCloseable();
        ) {
            System.out.println("INSIDE TRY");
            String s = null;
            s.toLowerCase();
        } catch (Exception ex) {
           // ex.printStackTrace();
            System.out.println("ex: "+ex.getMessage());
        } finally {
            System.out.println("finally");
        }
    }


}
