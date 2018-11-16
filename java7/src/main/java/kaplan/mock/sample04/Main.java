/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaplan.mock.sample04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        // not compile
        //Map<Double, List<String>> grades = new HashMap<Double, ArrayList<String>>();
        
        Map<Double, List<String>> grades = new HashMap<>();
        List<String> students = Arrays.asList("Sam", "Mary", "Ann");
        grades.put(98.5, students);
        
        students = Arrays.asList("George", "Aima");
        grades.put(88.2, students);
        
        students = Arrays.asList("Bob", "Christen", "Robin");
        grades.put(76.8, students);
        
        for(Map.Entry<Double, List<String>> gradeEntry : grades.entrySet()){
            System.out.printf("Students with %s : %s\n", gradeEntry.getKey(), gradeEntry.getValue().toString());
        }
        
    }
    
}
