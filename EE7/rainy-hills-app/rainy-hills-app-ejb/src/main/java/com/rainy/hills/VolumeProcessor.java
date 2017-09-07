/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rainy.hills;

import javax.ejb.Remote;

/**
 *
 * @author Denis
 */
@Remote
public interface VolumeProcessor {

    public int processVolume(int[] data);

}
