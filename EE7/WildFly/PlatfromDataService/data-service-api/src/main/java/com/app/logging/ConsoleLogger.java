/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.logging;

import javax.enterprise.event.Observes;

/**
 *
 * @author denys.prokopiuk
 */
public class ConsoleLogger {

    public void onTextMessage(@Observes String textMessage) {
        System.out.println(textMessage);
    }

}
