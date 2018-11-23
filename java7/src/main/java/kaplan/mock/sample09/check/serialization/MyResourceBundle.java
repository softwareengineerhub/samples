/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaplan.mock.sample09.check.serialization;

import java.io.Console;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.ResourceBundle;
import java.util.logging.ConsoleHandler;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyResourceBundle {

    //BaseLocale base = BaseLocale.createInstance("language", "country");*
    public static void main(String[] args) {
        //System.console();
        ResourceBundle rb = ResourceBundle.getBundle("Sample");
        Object content = rb.getObject("content");
        String name = rb.getBaseBundleName();
        System.out.println("content=" + content);        
        System.out.println("bundle.name=" + name);
        System.out.println("--------------------------");                
        System.out.println("----------FRANCE----------------");                
        rb = ResourceBundle.getBundle("Sample", Locale.FRANCE);
        content = rb.getObject("content");
        name = rb.getBaseBundleName();
        System.out.println("content=" + content);        
        System.out.println("bundle.name=" + name);        
        System.out.println("--------------------------");                
        System.out.println("----------FRENCH----------------");                
        rb = ResourceBundle.getBundle("Sample", Locale.FRENCH);
        content = rb.getObject("content");
        name = rb.getBaseBundleName();
        System.out.println("content=" + content);        
        System.out.println("bundle.name=" + name);        
        System.out.println("--------------------------");                
        System.out.println("----------ITALIAN----------------");                
        rb = ResourceBundle.getBundle("Sample", Locale.ITALY);
        content = rb.getObject("content");
        name = rb.getBaseBundleName();
        System.out.println("content=" + content);        
        System.out.println("bundle.name=" + name);        
        
        //Takes by the 1st parameter (language)
        System.out.println("--------------------------");                
        System.out.println("----------My Test----------------");                
        //rb = ResourceBundle.getBundle("Sample", new Locale("language", "country"));
        //rb = ResourceBundle.getBundle("Sample", new Locale("fr", "FR"));
        rb = ResourceBundle.getBundle("Sample", new Locale("it", "FR"));
        content = rb.getObject("content");
        name = rb.getBaseBundleName();
        System.out.println("content=" + content);        
        System.out.println("bundle.name=" + name);
        //Console console = System.console();
        
        Locale locale = Locale.GERMANY;
        Locale l1 = new Locale("language", "country");
        Locale l2 = new Builder().setLanguage("it").setRegion("it").build();
        Locale loc3 = Locale.forLanguageTag("en-US-x-lvariant-POSIX");
        //Locale l2 = Locale.Builder
        
        
    }

}
