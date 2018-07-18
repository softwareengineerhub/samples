/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch05.concurrent.scheduled.executor;

import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless
public class MyScheduledExecutorBean {

    @Resource(name = "java:comp/DefaultManagedScheduledExecutorService")
    private ManagedScheduledExecutorService scheduledExecutorService;

    public void scheduleUserTask() {
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.println("ManagedScheduledExecutorService task. @START");
                long start = System.currentTimeMillis();
                //while (System.currentTimeMillis() - start <= 20000) {
                //}
                System.out.println("ManagedScheduledExecutorService. @FINISH");
            }

        }, 10, 5, TimeUnit.SECONDS);
    }

}
