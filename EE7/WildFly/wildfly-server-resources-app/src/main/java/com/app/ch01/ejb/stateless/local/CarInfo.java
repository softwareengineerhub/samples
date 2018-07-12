/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.stateless.local;

import javax.ejb.Local;

/**
 *
 * @author denys.prokopiuk
 */
@Local
public interface CarInfo {

    public String getCarInfo();

}
