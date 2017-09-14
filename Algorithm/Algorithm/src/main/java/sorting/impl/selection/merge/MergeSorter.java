/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting.impl.selection.merge;

import java.util.Arrays;
import sorting.Sorter;

/**
 *
 * @author prokopiukd
 */
public class MergeSorter implements Sorter {

    @Override
    public void sort(int[] data) {
        if(data.length<=1){
            return;
        }
        
        int[] low = new int[data.length/2];
        int[] height = new int[data.length-low.length];
        
        System.arraycopy(data, 0, low, 0, low.length);
        System.arraycopy(data, low.length, height, 0, height.length);
        
        sort(low);
        sort(height);
        merge(low, height, data);
    }

    private void merge(int[] low, int[] height, int[] result) {
        int lowIndex = 0;
        int heightIndex = 0;
        int n=0;
        while(lowIndex<low.length && heightIndex<height.length){
            if(low[lowIndex]>=height[heightIndex]){
                result[n]=low[lowIndex++];
            }else{
                result[n]=height[heightIndex++];
            }
            n++;
        }
        System.arraycopy(low, lowIndex, result, n, low.length-lowIndex);
        System.arraycopy(height, heightIndex, result, n, height.length-heightIndex);
    }
    
    public static void main(String[] args) {
        Sorter sorter = new MergeSorter();
        int[] data = {1, 9, 50, -10, 45, 37, 9, 100, -5};
        sorter.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
