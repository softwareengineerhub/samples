/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting.impl.bubble;

import com.algorithm.tasks.swap.Swap;
import java.util.Arrays;
import sorting.Sorter;

/**
 *
 * @author Denis
 */
public class BubbleSorter implements Sorter {

    @Override
    public void sort(int[] data) {
        Swap swap = new Swap();
        for(int i=0;i<data.length-1;i++){
            for(int j=i+1;j<data.length;j++){
                if(data[i]>data[j]){                   
                    swap.swap(data, i, j);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        BubbleSorter bubbleSorter = new BubbleSorter();
        int[] data = {1,9,0,-10,45};
        bubbleSorter.sort(data);
        System.out.println(Arrays.toString(data));
    }
    
}
