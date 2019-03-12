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
    private String str="";
    
    
    
    public void sort(int[] data) {
        System.out.println("------------------------");
        System.out.println(str+Arrays.toString(data));
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
        int rightIndex = data.length-1;
        int pivotIndex = data.length / 2;
        int pivot = data[pivotIndex];
        System.out.println("\t"+"pivot="+pivot);
        while (leftIndex!=pivotIndex && rightIndex!=pivotIndex) {
            //System.out.println("\t"+Arrays.toString(data));
            if (data[leftIndex] > pivot && data[rightIndex] < pivot) {
                swap(data, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            } else if (data[leftIndex] > pivot) {
                rightIndex--;
         //       System.out.println("\t"+"right--");
            } else {
           //     System.out.println("\t"+"left++");
                leftIndex++;
            }
        }        
        if(data[leftIndex]>pivot){
           swap(data, pivotIndex, leftIndex);
        }else if(data[rightIndex]<pivot){
            swap(data, pivotIndex, rightIndex);
        }
        //System.out.println("###################"+Arrays.toString(data));
        int[] leftTmp = Arrays.copyOfRange(data, 0, pivotIndex+1);
        int[] rightTmp = Arrays.copyOfRange(data, pivotIndex+1, data.length);
        //System.out.println("\t\t\t###################left="+Arrays.toString(leftTmp));
        //System.out.println("\t\t\t###################right="+Arrays.toString(rightTmp));
        sort(leftTmp);
        
        
        sort(rightTmp);
        //sort(data,pivotIndex+1, data.length);
        /*sort(leftTmp);
        sort(rightTmp);
        */
        
        System.out.println("\t\t\t\t@@@@@@@@@@@@@@@@@@@left:"+Arrays.toString(leftTmp));
        System.out.println("\t\t\t\t@@@@@@@@@@@@@@@@@@@right"+Arrays.toString(rightTmp));
        int i=0;
        for(;i<leftTmp.length;i++){
            data[i] = leftTmp[i];
        }
        for(int j=0;j<rightTmp.length;j++){
            data[i++] = rightTmp[j];
        }
        System.out.println("\t\t\t\t###################"+Arrays.toString(data));
    }

    private void swap(int[] data, int i, int j) {
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

}
