/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app03.constructorref2;

/**
 *
 * @author asusadmin
 */
public class MyData2 {
    private String name;
    private int age;

    public MyData2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyData2{" + "name=" + name + ", age=" + age + '}';
    }
    
    
}
