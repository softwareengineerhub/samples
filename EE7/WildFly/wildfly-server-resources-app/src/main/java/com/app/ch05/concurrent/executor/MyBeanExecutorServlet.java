/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch05.concurrent.executor;

import java.io.IOException;
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
@WebServlet(name = "MyBeanExecutorServlet", urlPatterns = {"/MyBeanExecutorServlet"})
public class MyBeanExecutorServlet extends HttpServlet {

    @EJB
    private MyBeanExecutor myBeanExecutor;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        myBeanExecutor.submitTask();
    }

}
