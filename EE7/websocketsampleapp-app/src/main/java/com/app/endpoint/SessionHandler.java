package com.app.endpoint;

import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SessionHandler {
    private static SessionHandler instance = new SessionHandler();
    private List<Session> sessions = new ArrayList<>();

    private SessionHandler(){
    }

    public static SessionHandler getInstance(){
        return instance;
    }

    public void addSession(Session session){
        sessions.add(session);
    }

    public void sendMessageToAll(String message, Session currentClientSession){
        for(Session session : sessions){
            if(!currentClientSession.equals(session)) {
                try {
                    session.getBasicRemote().sendText("Hey, you got a message: " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void deleteSession(Session session){
        sessions.remove(session);
    }

}
