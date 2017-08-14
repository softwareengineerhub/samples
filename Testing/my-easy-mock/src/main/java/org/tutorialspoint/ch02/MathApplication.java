/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutorialspoint.ch02;

/**
 *
 * @author prokopiukd
 */
public class MathApplication {

    private CalculatorService calculatorService;

    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public double add(double a, double b) {
        return calculatorService.add(a, b);
    }

    public double divide(double a, double b) {
        return calculatorService.divide(a, b);
    }

    public double multiply(double a, double b) {
        return calculatorService.multiply(a, b);
    }

    public double subtrack(double a, double b) {
        return calculatorService.subtrack(a, b);
    }
}
