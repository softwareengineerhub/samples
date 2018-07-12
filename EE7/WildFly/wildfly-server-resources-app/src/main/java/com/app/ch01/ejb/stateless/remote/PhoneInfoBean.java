/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.stateless.remote;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless(name = "phoneInfoBean")
@Remote(PhoneInfo.class)
public class PhoneInfoBean {

    //@Override
    public String getPhoneInfo() {
        return "phoneInfoBean";
    }

}
