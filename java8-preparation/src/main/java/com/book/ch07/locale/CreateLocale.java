package com.book.ch07.locale;

import java.util.Locale;

public class CreateLocale {

    public static void main(String[] args) {
        System.out.println("---------Default-----------------");
        Locale localeDefault = Locale.getDefault();
        System.out.println("localeDefault="+localeDefault);

        System.out.println("------------Constructor--------------");
        String language = "it";
        String country = "IT";
        Locale localeIT = new Locale(language, country);
        System.out.println("localeIT="+localeIT);

        System.out.println("------------Constructor only language--------------");
        String myLanguage = "it";
        Locale myLocaleIT = new Locale(myLanguage);
        System.out.println("myLocaleIT="+myLocaleIT);

        System.out.println("------------Builder--------------");
        Locale localeFR = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
        System.out.println("localeFR="+localeFR);

        System.out.println("------------Tag--------------");
        Locale usLocale = Locale.forLanguageTag("en-US");
        System.out.println("usLocale="+usLocale);

        System.out.println("------------Constants--------------");
        Locale l1 = Locale.FRENCH;
        System.out.println(l1);
        Locale l2 = Locale.FRANCE;
        System.out.println(l2);



    }

}
