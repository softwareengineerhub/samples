/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qqq.app03;

import java.util.Locale;

/**
 *
 * @author Denys.Prokopiuk
 */
public class App03 {

    public static void main(String[] args) {
        Locale localeDefault = Locale.getDefault();
        System.out.println("localeDefault=" + localeDefault);
        String language = "it";
        String country = "IT";
        Locale localeIT = new Locale(language, country);
        System.out.println("localeIT=" + localeIT);
        Locale localeFR = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
        System.out.println("localeFR=" + localeFR);
        Locale usLocale = Locale.forLanguageTag("en-US");
        System.out.println("usLocale=" + usLocale);
        System.out.println("-----------------------------");
        Locale fr1 =Locale.FRANCE;
        System.out.println("FR1=" + fr1);
        Locale fr2 =Locale.FRENCH;
        System.out.println("FR2=" + fr2);
    }

}
