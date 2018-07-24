/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.client;

import com.app.model.DataMessage;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author denys.prokopiuk
 */
public class ApiClientImpl implements ApiClient {

    private Client client;
    private String servicePath;

    public ApiClientImpl(String servicePath) {
        this.servicePath = servicePath;
        client = ClientBuilder.newClient();
    }

    @Override
    public int save(DataMessage dataMessage) {
        Response response = client.target(servicePath).request(MediaType.APPLICATION_JSON).put(Entity.entity(dataMessage, MediaType.APPLICATION_JSON), Response.class);
        return response.getStatus();
    }

    @Override
    public DataMessage get() {
        return client.target(servicePath).request().get(DataMessage.class);
    }

}
