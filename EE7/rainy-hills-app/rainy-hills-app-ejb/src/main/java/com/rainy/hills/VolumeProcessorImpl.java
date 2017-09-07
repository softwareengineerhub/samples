/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rainy.hills;

import javax.ejb.Stateless;

/**
 *
 * @author Denis
 */
@Stateless(name = "volumeProcessorImpl")
public class VolumeProcessorImpl implements VolumeProcessor {

    @Override
    public int processVolume(int[] data) {
        int volume = 0;
        int leftMax = 0;
        int rightMax = 0;
        int leftIndex = 0;
        int rightIndex = data.length - 1;
        while (leftIndex < rightIndex) {
            if (data[leftIndex] > leftMax) {
                leftMax = data[leftIndex];
            }
            if (data[rightIndex] > rightMax) {
                rightMax = data[rightIndex];
            }
            int max;
            int index;
            if (leftMax < rightMax) {
                max = leftMax;
                index = leftIndex++;
            } else {
                max = rightMax;
                index = rightIndex--;
            }
            volume += (max - data[index]);
        }
        return volume;
    }

}
