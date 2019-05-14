/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myquicksort;

import java.util.Arrays;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyQuickSorterImpl {

    public void sort(int[] data) {
        if (data.length <= 1) {
            return;
        }
        if (data.length == 2) {
            if (data[0] > data[1]) {
                swap(data, 0, 1);
            }
            return;
        }
        int leftIndex = 0;
        int rightIndex = data.length - 1;
        int pivotIndex = data.length / 2;
        int pivot = data[pivotIndex];
        while (leftIndex != pivotIndex && rightIndex != pivotIndex) {
            if (data[leftIndex] > pivot && data[rightIndex] < pivot) {
                swap(data, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            } else if (data[leftIndex] > pivot) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        if (data[leftIndex] > pivot) {
            swap(data, pivotIndex, leftIndex);
        } else if (data[rightIndex] < pivot) {
            swap(data, pivotIndex, rightIndex);
        }

        int[] leftTmp = null;
        int[] rightTmp = null;

        if (data.length % 2 == 0) {
            leftTmp = Arrays.copyOfRange(data, 0, pivotIndex);
            rightTmp = Arrays.copyOfRange(data, pivotIndex, data.length);
        } else {
            leftTmp = Arrays.copyOfRange(data, 0, pivotIndex + 1);
            rightTmp = Arrays.copyOfRange(data, pivotIndex + 1, data.length);
        }
        sort(leftTmp);
        sort(rightTmp);
        int i = 0;
        for (; i < leftTmp.length; i++) {
            data[i] = leftTmp[i];
        }
        for (int j = 0; j < rightTmp.length; j++) {
            data[i++] = rightTmp[j];
        }
        System.out.println("\t\t\t\t###################" + Arrays.toString(data));
    }

    private void swap(int[] data, int i, int j) {
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

}
