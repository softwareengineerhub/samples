/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.stateless.local;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless(name = "carInfoBean")
@Local(CarInfo.class)
public class CarInfoBean {

    public String getCarInfo() {
        System.out.println("getCarInfo()");
        return "my-car2";
    }
}
