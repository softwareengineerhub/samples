/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch02.beanvalidation;

import javax.validation.Valid;

/**
 *
 * @author denys.prokopiuk
 */
public interface AccountProcessor {
    
    public void process(@Valid UserAccount userAccount);
    
}
