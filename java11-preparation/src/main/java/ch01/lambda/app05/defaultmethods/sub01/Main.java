/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app05.defaultmethods.sub01;

/**
 *
 * @author DProkopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        ParentA parentA = new Child();
        parentA.m();
        ParentB parentB = new Child();
        parentB.m();
        System.out.println("------------------");
        ChildC childC = new ChildC();
        childC.m();
        System.out.println("------------------");
        ParentA aChcildC = new ChildC();
        aChcildC.m();
        System.out.println("------------------");
        ParentB bChcildC = new ChildC();
        bChcildC.m();
        
    }
    
}
