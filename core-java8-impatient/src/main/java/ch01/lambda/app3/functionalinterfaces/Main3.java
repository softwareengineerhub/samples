/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app3.functionalinterfaces;

/**
 *
 * @author prokopiukd
 */
public class Main3 {

    public static void main(String[] args) {
        MyProcessor myProcessor = (int a) -> {
            return a + 10;
        };
        int res = myProcessor.process(0);
        System.out.println("res=" + res);
    }

}
