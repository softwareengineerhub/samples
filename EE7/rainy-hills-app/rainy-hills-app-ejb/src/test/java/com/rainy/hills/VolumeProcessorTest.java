/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rainy.hills;

import java.util.Arrays;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Denis
 */
public class VolumeProcessorTest {

    private VolumeProcessor volumeCalculator;

    @Before
    public void before() {
        volumeCalculator = new VolumeProcessorImpl();
    }

    @Test
    public void calculateVolumeTest() {
        int[] data = {3, 2, 4, 1, 2};
        processValidation(data, 2);
        data = new int[]{4, 1, 1, 0, 2, 3};
        processValidation(data, 8);

        processValidation(new int[]{1}, 0);
        processValidation(new int[]{1}, 0);
        processValidation(new int[]{1, 2}, 0);
        processValidation(new int[]{2, 1}, 0);
        processValidation(new int[]{2, 1, 2}, 1);
        processValidation(new int[]{1, 2, 1}, 0);
        processValidation(new int[]{3, 1, 2}, 1);
        processValidation(new int[]{2, 1, 3}, 1);
        processValidation(new int[]{2, 2, 2}, 0);
        processValidation(new int[]{2, 2, 3}, 0);
        processValidation(new int[]{3, 2, 2}, 0);
        processValidation(new int[]{3, 4, 7, 3, 4, 7, 6, 7, 2, 4}, 10);
        processValidation(new int[]{6, 1, 5, 2, 1, 4}, 9);
        processValidation(new int[]{5, 1, 3, 6, 1, 6, 1, 3, 1, 4}, 18);
        processValidation(new int[]{5, 1, 3}, 2);
        processValidation(new int[]{7, 1, 1, 1, 7, 1, 1, 1, 1, 7}, 42);
        processValidation(new int[]{7, 1, 3, 6, 1, 5, 1, 7, 6, 5}, 25);
        processValidation(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 0);
        processValidation(new int[]{7, 1, 5, 2, 1, 4}, 9);
        processValidation(new int[]{2, 5, 1, 3, 1, 2, 1, 7, 7, 6}, 17);
        processValidation(new int[]{5, 1, 5, 1, 5, 1, 5}, 12);
        processValidation(new int[]{4, 1, 2, 5, 1, 6}, 9);
        processValidation(new int[]{6, 1, 1, 1, 7, 1, 1, 1, 1, 7}, 39);
        processValidation(new int[]{7, 1, 5, 2, 1, 4, 3, 2}, 9);
        processValidation(new int[]{8, 7, 6, 5, 4, 3, 2, 1}, 0);
        processValidation(new int[]{7, 1, 5, 2, 1, 4, 2}, 9);
        processValidation(new int[]{5, 1, 3, 6, 1, 5, 1, 7, 6, 5}, 17);
        processValidation(new int[]{0, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1}, 1);
        processValidation(new int[]{2, 5, 1, 2, 3, 4, 7, 7, 6}, 10);
        processValidation(new int[]{6, 7, 7, 4, 3, 2, 1, 5, 2}, 10);
        processValidation(new int[]{5, 1, 4, 2, 3}, 4);
        processValidation(new int[]{7, 1, 5, 2, 1, 4, 3, 2}, 9);
        processValidation(new int[]{1, 5, 1, 5, 1, 5, 1}, 8);
        processValidation(new int[]{1, 2, 3, 4, 5, 5, 4, 3, 2, 1}, 0);
    }

    private void processValidation(int[] data, int expectedVolume) {
        int actualVolume = volumeCalculator.processVolume(data);
        assertTrue(String.format("%s. ActualVolume=%s. ExpectedVolume=%s", Arrays.toString(data), actualVolume, expectedVolume), expectedVolume == actualVolume);
    }

}
