/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch05.concurrent.executor;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless
public class MyBeanExecutor {

    @Resource(name = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService managedExecutorService;

    public void submitTask() {
        managedExecutorService.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("Concurrent task. @START");
                long start = System.currentTimeMillis();
                while (System.currentTimeMillis() - start <= 20000) {
                }
                System.out.println("Concurrent task. @FINISH");
            }

        });
    }

}
