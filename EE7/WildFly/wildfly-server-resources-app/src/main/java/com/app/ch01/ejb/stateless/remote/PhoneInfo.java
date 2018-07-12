/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.stateless.remote;

import javax.ejb.Remote;

/**
 *
 * @author denys.prokopiuk
 */
@Remote
public interface PhoneInfo {

    public String getPhoneInfo();

}
