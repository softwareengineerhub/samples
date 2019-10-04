/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app02.methodref.inheritence;

/**
 *
 * @author DProkopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        ConcurrentGreeter cg = new ConcurrentGreeter();
        cg.greet();
        System.out.println("main--FINISH");
    }
    
}
