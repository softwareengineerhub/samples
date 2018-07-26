/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.common.client;

import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author denys.prokopiuk
 */
public class APIClientImpl implements APIClient {

    private Client client;
    private String servicePath;

    public APIClientImpl(String servicePath) {
        this.servicePath = servicePath;
        //client = ClientBuilder.newClient();
    }

    @Override
    public long count() {
        try {
            client = ClientBuilder.newClient();
            return client.target(servicePath + "/count").request().get(Long.class);
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    @Override
    public int put() {
        try {
            client = ClientBuilder.newClient();
            String input = getJSON("/request.json");
            Response response = client.target(servicePath).request(MediaType.APPLICATION_JSON).put(Entity.entity(input, MediaType.APPLICATION_JSON));
            return response.getStatus();
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    @Override
    public String getJSON(String fileName) {
        try (InputStream in = getClass().getResourceAsStream(fileName);) {
            byte[] data = new byte[in.available()];
            in.read(data);
            return new String(data);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
