/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.advanced.design.sample4;

/**
 *
 * @author Denys.Prokopiuk
 */
public class TestClassS4 {

    private String name = "Name";
    private final int age = 1;
    private static String department = "Alpha";

    public class MyInnerClass4 {

        public void m4() {
            System.out.println(name);
            System.out.println(age);
            System.out.println(department);
            name = "Test";
        }
    }

    public String getName() {
        return name;
    }
    
   

}
