/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.impl.binary;

import search.Search;

/**
 *
 * @author Denis
 */
public class BinarySearchImpl implements Search {

    @Override
    public int search(int value, int[] data) {
        int low = 0;
        int high = data.length - 1;
        while (high - low > 0) {
            int middle = (high - low) / 2;
            if (data[middle] == value) {
                return middle;
            }
            if (data[middle] > value) {
                high--;
            } else {
                low++;
            }
        }
        return -1;
    }

}
