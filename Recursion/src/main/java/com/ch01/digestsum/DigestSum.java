/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch01.digestsum;

/**
 *
 * @author prokopiukd
 */
public class DigestSum {

    public int sum(int a) {
        if (a == 0) {
            return 0;
        }
        return a % 10 + sum(a / 10);
    }

    public int sum2(int a) {
        int sum = 0;
        while (a / 10 != 0) {
            sum += a % 10;
            a = a / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        DigestSum digestSum = new DigestSum();
        int res = digestSum.sum(5);
        System.out.println("res=" + res);
        res = digestSum.sum(5);
        System.out.println("res=" + res);
    }

}
