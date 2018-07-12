/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.stateless.local;

import javax.ejb.Stateless;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless(name = "carInfoImpl")
public class CarInfoImpl implements CarInfo {

    @Override
    public String getCarInfo() {
        System.out.println("getCarInfo()");
        return "my-car";
    }

}
