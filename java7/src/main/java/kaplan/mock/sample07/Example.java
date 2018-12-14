/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaplan.mock.sample07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Example {

    public static void main(String[] args) {
        List<String> grades = new ArrayList();
        grades.addAll(Arrays.asList(new String[]{"A", "B", "C", "D", "E"}));
        Collections.rotate(grades, 1);
        System.out.println(grades);
    }

}
