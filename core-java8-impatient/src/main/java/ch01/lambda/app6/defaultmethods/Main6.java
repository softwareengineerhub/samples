/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app6.defaultmethods;

/**
 *
 * @author prokopiukd
 */
public class Main6 {

    public static void main(String[] args) {
        Parent parent = new Parent() {};
        parent.makeAction();
        Child child = new Child(){};
        child.makeAction();
        
        Parent p1 = new Child(){};
        p1.makeAction();
        
        B.testMethod();
    }
}
