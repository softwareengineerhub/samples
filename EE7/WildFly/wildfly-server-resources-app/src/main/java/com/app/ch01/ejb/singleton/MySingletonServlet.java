/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.singleton;

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
@WebServlet(name = "MySingletonServlet", urlPatterns = {"/MySingletonServlet"})
public class MySingletonServlet extends HttpServlet {

    @EJB
    private MySingleton mySingleton;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Call started. param=" + req.getParameter("a"));
        String result = mySingleton.getGender();
        resp.getWriter().append("result:" + result);
        System.out.println("Call finished. param=" + req.getParameter("a"));
    }

}
