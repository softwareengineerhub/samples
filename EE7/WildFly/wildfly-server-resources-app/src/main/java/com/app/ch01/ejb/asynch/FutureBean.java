/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.asynch;

import java.util.concurrent.Future;

/**
 *
 * @author denys.prokopiuk
 */
public interface FutureBean {

    public Future<String> process(String data);

}
