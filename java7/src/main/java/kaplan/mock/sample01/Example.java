/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaplan.mock.sample01;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Example {

    public static void doSomething() {
        System.out.println("action");
        try {
            System.out.println("try");
            throw new IllegalStateException();
        } catch (Exception ex) {
            System.out.println("caught ");
            throw ex;
        } finally {
            System.out.println("cleanup");
        }
    }

    public static void main(String[] args) {
        System.out.println("app-in");
        try {
            doSomething();
            System.out.println("main-in");
        } finally {
            System.out.println("main-out");
        }
        System.out.println("app-out");
    }

}
