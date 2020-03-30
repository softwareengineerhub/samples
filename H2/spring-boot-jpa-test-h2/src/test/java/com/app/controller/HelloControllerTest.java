/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author asusadmin
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloControllerTest {

    @InjectMocks
    private HelloWorldController helloWorldController;

    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
    }

    @Test
    public void test() throws Exception {
        MockHttpServletRequestBuilder mhsrb = MockMvcRequestBuilders.get("/hello/world");
        ResultActions resultActions = mockMvc.perform(mhsrb);
        resultActions = resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions = resultActions.andExpect(MockMvcResultMatchers.content().string("HelloWorld"));

    }

    @Test
    public void test2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/world"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("HelloWorld"));
    }
    
    
    @Test
    public void testHelloCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/customer").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Name1"));
                
    }

}
