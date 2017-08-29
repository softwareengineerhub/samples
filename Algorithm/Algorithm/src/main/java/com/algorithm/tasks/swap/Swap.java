/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithm.tasks.swap;

import java.util.Arrays;

/**
 *
 * @author Denis
 */
public class Swap {

    public void swap(int[] data, int i, int j) {
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

}
