package com.book.ch04.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class MainApp {

    public static void main(String[] args) {
        Locale l = new Locale("fr", "IT");
        ResourceBundle rb = ResourceBundle.getBundle("data", l);
        String name=rb.getString("name");
        System.out.println("name="+name);
    }

}
