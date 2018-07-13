/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.asynch;

import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless
public class FutureBeanImpl implements FutureBean {

    @Asynchronous
    @Override
    public Future<String> process(String data) {
        System.out.println("\tprocess().START");
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= 30000) {

        }
        System.out.println("\tprocess().END");
        return new AsyncResult<>("Finish");
    }

}
