/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch03.jms;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denys.prokopiuk
 */
@WebServlet(name = "MessageProducerServlet", urlPatterns = {"/MessageProducerServlet"})
public class MessageProducerServlet extends HttpServlet {
    
    @EJB
    private MyMessageProducer messageProducer;
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int salary = Integer.parseInt(req.getParameter("salary"));
        boolean active = Boolean.parseBoolean(req.getParameter("active"));
        String type = req.getParameter("type");
        messageProducer.sendMessage(salary, active, type);
    }
    
}
