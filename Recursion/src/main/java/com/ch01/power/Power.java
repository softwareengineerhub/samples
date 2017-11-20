/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch01.power;

/**
 *
 * @author prokopiukd
 */
public class Power {

    public int powerN(int base, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        return base * powerN(base, n - 1);
    }

    public int m(int base, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        return base * m(base, n - 1);
    }

    public static void main(String[] args) {
        Power power = new Power();
        int res = power.powerN(2, 8);
        System.out.println("res=" + res);
        res = power.m(3, 4);
        System.out.println("res=" + res);
    }

}
