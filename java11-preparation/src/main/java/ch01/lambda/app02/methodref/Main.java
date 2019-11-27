/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app02.methodref;

import java.util.Arrays;
import java.util.Comparator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *
 * @author DProkopiuk
 */
public class Main {

    public static void main(String[] args) {
        BusinessInterface bi = s -> {
            System.out.println(s);
        };
        bi.doAction("str");
        System.out.println("------------------------------");

        
        Button btn = new Button();
        btn.setOnAction(event -> System.out.println(event));
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });
        System.out.println("------------------------------");

        btn = new Button();
        btn.setOnAction(System.out::println);
        System.out.println("------------------------------");
        String[] strings = {"a", "B", "c"};
        "".compareTo("");
        Arrays.sort(strings, String::compareToIgnoreCase);
        
        Comparable comparable = new Comparable<String>(){
            @Override
            public int compareTo(String o) {
                return "".compareTo(o);
            }
            
        };
        
        Comparator comparator = new Comparator(){
            
            @Override
            public int compare(Object o1, Object o2) {
                return 1;
            }
            
        };
        
       
        
        Arrays.sort(args, comparator);
    }

}
