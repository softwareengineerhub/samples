/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.udp.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author DProkopiuk
 */
public class UDPServer {

    public static void main(String[] args) throws Exception {        
        int port = 8082;
        
                
        byte[] buffer = new byte[512];
        DatagramPacket request = new DatagramPacket(buffer, buffer.length);
        
        DatagramSocket socket = new DatagramSocket(port);
        socket.receive(request);
        System.out.println("Data was received");
        //Thread.sleep(1000);
        String requestContent = new String(buffer, 0, buffer.length);        
        System.out.println("Request content: "+requestContent);
        
        InetAddress clientAddress = request.getAddress();
        byte[] responseBuff = "OK".getBytes();
        int clientPort = request.getPort();
        DatagramPacket response = new DatagramPacket(responseBuff, responseBuff.length, clientAddress, clientPort);
        socket.send(response);
    }

}
