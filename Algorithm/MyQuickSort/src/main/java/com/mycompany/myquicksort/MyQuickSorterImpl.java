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
 * https://www.youtube.com/watch?v=Fiot5yuwPAg
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

        System.out.println("###################" + Arrays.toString(data));
        int[] leftTmp = null;
        int[] rightTmp = null;
        if (data[pivotIndex] < pivot) {
            leftTmp = new int[pivotIndex + 1];
            rightTmp = new int[data.length - leftTmp.length];
            System.arraycopy(data, 0, leftTmp, 0, pivotIndex + 1);
            System.arraycopy(data, pivotIndex + 1, rightTmp, 0, rightTmp.length);
        } else {
            leftTmp = new int[pivotIndex];
            rightTmp = new int[data.length - leftTmp.length];
            System.arraycopy(data, 0, leftTmp, 0, pivotIndex);
            System.arraycopy(data, pivotIndex, rightTmp, 0, rightTmp.length);
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

    }

    private void swap(int[] data, int i, int j) {
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

}
