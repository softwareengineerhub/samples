/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.impl.linear;

import search.Search;

/**
 *
 * @author Denis
 */
public class LinearSearchImpl implements Search {

    @Override
    public int search(int value, int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

}
