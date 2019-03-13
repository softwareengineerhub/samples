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
public class Main {

    public static void main(String[] args) {
        //int[] data = {17, 6, 5, 3, 22, 41, 54, 29, 14};
        int[] data = {177, 6, 5, 3, 22, 41, 54, 29, 28};
        //int[] data = {41, 54, 29, 22};
        MyQuickSorterImpl myQuickSorterImpl = new MyQuickSorterImpl();
        myQuickSorterImpl.sort(data);
        System.out.println("res="+Arrays.toString(data));
    }
    
}
