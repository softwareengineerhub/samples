/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app02.methodref;

import java.util.Arrays;
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
        System.out.println("------------------------------");

        btn = new Button();
        btn.setOnAction(System.out::println);
        System.out.println("------------------------------");
        String[] strings = {"a", "B", "c"};
        Arrays.sort(strings, String::compareToIgnoreCase);
    }

}
