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
public interface MyProcessor {

    public int process(int a);

    public default int calculate(int a, int b) {
        return a + b;
    }

}
