/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.common.client.APIClient;
import com.app.common.client.APIClientImpl;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author denys.prokopiuk
 */
public class ServiceTest {

    private APIClient client;

    @Before
    public void init() {
        client = new APIClientImpl("http://localhost:8080/data-service/api");
    }

    @Ignore
    @Test
    public void ediServiceTest() {
        long count = client.count();
        client.put();
        long countAfterPut = client.count();
        assertTrue(count + 1 == countAfterPut);
    }

}
