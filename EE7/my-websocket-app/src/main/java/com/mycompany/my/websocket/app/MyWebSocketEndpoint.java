/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.websocket.app;

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
@ServerEndpoint("/endpoint")
public class MyWebSocketEndpoint {

   /* @OnOpen
    public void init() {
        System.out.println("init().hashCode=" + hashCode());
    }
    */
    
    @OnOpen
    public void init(Session session) {
        System.out.println("init(Session).hashCode=" + hashCode()+"; session="+session);
        onMessage("Test");
    }

    @OnMessage
    public String onMessage(String message) {
        System.out.println("OnMessage:" + message);
        //session.getBasicRemote().sendText(message.toString());
        return message + ".Response";
    }

    /*@OnClose
    public void destroy() {
        System.out.println("destroy().hashCode=" + hashCode());
    }*/
    
    @OnClose
    public void destroy(Session session) {
        System.out.println("destroy(Session).hashCode=" + hashCode()+"; session="+session);
    }
    
    @OnError
    public void onError(Throwable ex){
        ex.printStackTrace();
    }

}
