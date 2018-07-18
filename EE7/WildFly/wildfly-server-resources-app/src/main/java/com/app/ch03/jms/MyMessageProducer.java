/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch03.jms;

/**
 *
 * @author denys.prokopiuk
 */
public interface MyMessageProducer {

    public void sendMessage(int salary, boolean active, String type);

}
