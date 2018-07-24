/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.notification.producer;

import com.app.model.DataMessage;
import javax.ejb.Stateless;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless
public class ConsoleNotificationProducer implements NotificationProducer {

    @Override
    public void emit(DataMessage dataMessage) {
        System.out.println("Emit event on local machine");
    }
    
}
