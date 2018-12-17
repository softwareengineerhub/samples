/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magicpigeon.websocket;

import com.magicpigeon.model.Device;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.json.spi.JsonProvider;
import javax.websocket.Session;

/**
 * Handler for managing the Devices and Sessions in the Server side
 * @author dmerchang
 */
//@ApplicationScoped
public class DeviceSessionHandler {

    private static DeviceSessionHandler instance = new DeviceSessionHandler();

    
    private int deviceId = 0;
    private final Set<Session> sessions = new HashSet<>();
    private final Set<Device> devices = new HashSet<>();

    private DeviceSessionHandler(){

    }

    public void addSession(Session session) {
        sessions.add(session);
        for (Device device : devices) {
            String addMessage = createAddMessage(device);
            sendToSession(session, addMessage);
        }
    }
    
    public void removeSession(Session session) {
        sessions.remove(session);
    }
    
    public void addDevice(Device device) {
        device.setId(deviceId);
        devices.add(device);
        deviceId++;
        String addMessage = createAddMessage(device);
        sendToAllConnectedSessions(addMessage);
    }
    
    public void removeDevice(int id) {
        /*Device device = getDeviceById(id);
        if (device != null) {
            devices.remove(device);
            JsonProvider provider = JsonProvider.provider();
            JsonObject removeMessage = provider.createObjectBuilder()
                    .add("action", "remove")
                    .add("id", id)
                    .build();
            String updateDevMessage ="{'action':'remove','id':'"+device.getId()+"'""'}";


            sendToAllConnectedSessions(removeMessage);
        }*/
    }
    
    public void toggleDevice(int id) {
        JsonProvider provider = JsonProvider.provider();
        Device device = getDeviceById(id);
        if (device != null) {
            if ("On".equals(device.getStatus())) {
                device.setStatus("Off");
            } else {
                device.setStatus("On");
            }
            String updateDevMessage ="{'action':'toggle','id':'"+device.getId()+"','status':'"+device.getStatus()+"'}";
            /*provider.createObjectBuilder()
                    .add("action", "toggle")
                    .add("id", device.getId())
                    .add("status", device.getStatus())
                    .build();*/
            sendToAllConnectedSessions(updateDevMessage);
        }
    }
    
    private Device getDeviceById(int id) {
        for (Device device : devices) {
            if (device.getId() == id) {
                return device;
            }
        }
        return null;
    }

    private String createAddMessage(Device device) {
        return String.format("{'action':'%s','id':'%s','name':'%s','type':'%s','status':'%s','description':'%s'}",
                "add", device.getId(),device.getName(),device.getType(), device.getStatus(),device.getDescription()   );

    }

    private void sendToAllConnectedSessions(String message) {
        for (Session session : sessions) {
            sendToSession(session, message);
        }
    }

    private void sendToSession(Session session, String  message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException ex) {
            sessions.remove(session);
            Logger.getLogger(DeviceSessionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

public static DeviceSessionHandler getInstance(){
        return instance;
}
    
}
