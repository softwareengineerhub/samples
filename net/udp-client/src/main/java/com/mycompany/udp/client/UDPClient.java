/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.udp.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author DProkopiuk
 */
public class UDPClient {

    public static void main(String[] args) throws Exception {
        String hostname = "127.0.0.1";
        int port = 8082;
        InetAddress address = InetAddress.getByName(hostname);

        
        String message = "Hello";
        byte[] buffer = message.getBytes();
        DatagramPacket request = new DatagramPacket(buffer, buffer.length, address, port);
        

        DatagramSocket socket = new DatagramSocket();
        socket.send(request);

        System.out.println("Data was sent!!!!");
       // Thread.sleep(4000);
        
        DatagramPacket response = new DatagramPacket(buffer, buffer.length);
        socket.receive(response);
        
        String responseContent = new String(buffer, 0, response.getLength());
        System.out.println("responseContent="+responseContent);
    }

}
