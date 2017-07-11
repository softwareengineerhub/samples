/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author denys
 */
public class SampleMessageListener implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        System.out.println(msg);
    }
    
}
