/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch05.concurrent.scheduled.executor;

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
@WebServlet(name = "MyScheduledExecutorBeanServlet", urlPatterns = {"/MyScheduledExecutorBeanServlet"})
public class MyScheduledExecutorBeanServlet extends HttpServlet {

    @EJB
    private MyScheduledExecutorBean myScheduledExecutorBean;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        myScheduledExecutorBean.scheduleUserTask();
    }

}
