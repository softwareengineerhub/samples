/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting.impl.insertion;

import java.util.Arrays;
import sorting.Sorter;
import sorting.impl.bubble.BubbleSorter;

/**
 *
 * @author Denis
 */
public class InsertionSorter implements Sorter {

    @Override
    public void sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int k = i + 1;
            while (k > 0 && data[k] > data[k - 1]) {
                data[k] = data[k] + data[k - 1];
                data[k - 1] = data[k] - data[k - 1];
                data[k] = data[k] - data[k - 1];
                k--;
            }
            System.out.println(i + ". " + Arrays.toString(data));
        }
    }

    public static void main(String[] args) {
        Sorter sorter = new InsertionSorter();
        int[] data = {1, 9, 0, -10, 45, 37, 9, 100, -5};
        sorter.sort(data);
        System.out.println(Arrays.toString(data));
    }

}
