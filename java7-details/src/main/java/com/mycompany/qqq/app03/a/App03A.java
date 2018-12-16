/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qqq.app03.a;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Denys.Prokopiuk
 */
public class App03A {

    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("data");
        String capital = rb.getString("capital");
        System.out.println("capital=" + capital);
        System.out.println("--------------------");
        ResourceBundle rb1 = ResourceBundle.getBundle("data", Locale.ITALY);
        String capital1 = rb1.getString("capital");
        System.out.println("capital1=" + capital1);
        System.out.println("--------------------");
        ResourceBundle rb2 = ResourceBundle.getBundle("data", Locale.ITALIAN);
        String capital2 = rb2.getString("capital");
        System.out.println("capital2=" + capital2);
        System.out.println("--------------------");
        Locale localeMix = new Locale.Builder().setLanguage("fr").setRegion("IT").build();
        ResourceBundle rb3 = ResourceBundle.getBundle("data", localeMix);
        String capital3 = rb3.getString("capital");
        System.out.println("capital3=" + capital3);
        System.out.println("--------------------");
        //In case of incorrect language or Region --> RuntimeException:  java.util.IllformedLocaleException: Ill-formed language
        Locale localeRegion = new Locale.Builder().setRegion("JP").build();
        ResourceBundle rb4 = ResourceBundle.getBundle("data", localeRegion);
        String capital4 = rb4.getString("capital");
        System.out.println("capital4=" + capital4);
        System.out.println("--------------------");
        Locale localeLanguage = new Locale.Builder().setLanguage("ja").build();
        ResourceBundle rb5 = ResourceBundle.getBundle("data", localeLanguage);
        String capital5 = rb5.getString("capital");
        System.out.println("capital5=" + capital5);
        System.out.println("--------------------");
        Locale localeRegion2 = new Locale.Builder().setRegion("JP").build();
        ResourceBundle rb6 = ResourceBundle.getBundle("data", localeRegion2);
        String capital6 = rb6.getString("capital");
        System.out.println("capital6=" + capital6);        
        System.out.println("--------------------");
        Locale localeLanguage2 = new Locale.Builder().setLanguage("JP").build();
        ResourceBundle rb7 = ResourceBundle.getBundle("data", localeLanguage2);
        String capital7 = rb7.getString("capital");
        System.out.println("capital7=" + capital7);        
        
    }

}
