package com.app.endpoint;


import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ServerEndpoint("/serverWebSocket")
public class ServerWebSocket {
    private SessionHandler sessionHandler = SessionHandler.getInstance();

    @OnOpen
    public void init(Session session){
        sessionHandler.addSession(session);
    }

    @OnMessage
    public String onMessage(String message, Session currentClientSession){
        System.out.println(message);
        sessionHandler.sendMessageToAll(message, currentClientSession);
        return "ok"+message;
    }

    @OnClose
    public void onClose(Session session){
        sessionHandler.deleteSession(session);
    }

}
