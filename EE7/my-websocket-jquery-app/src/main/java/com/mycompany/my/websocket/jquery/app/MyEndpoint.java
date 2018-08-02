/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.websocket.jquery.app;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author denys.prokopiuk
 */
@ServerEndpoint(value = "/api")
public class MyEndpoint {

    @OnOpen
    public void init() {
        System.out.println("init()");
    }

    @OnMessage
    public String onMessage(String message) {
        System.out.println("message=" + message);
        return "test";
    }

    /*@OnMessage
    public void onMessage(String message){
        System.out.println("message="+message);
        //Session session = null;
        //session.getBasicRemote().sendText("");
    }*/
    @OnClose
    public void destory() {
        System.out.println("destroy()");
    }

    @OnError
    public void error(Throwable th) {
        th.printStackTrace();
    }

}
