/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.stateless.local;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denys.prokopiuk
 */
@WebServlet(name = "CarInfoLookupServlet", urlPatterns = {"/CarInfoLookupServlet"})
public class CarInfoLookupServlet extends HttpServlet {

    //@EJB(lookup = "java:module/carInfoBean")
    private CarInfo carInfo;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            System.out.println(name);
            InitialContext ctx = new InitialContext();
            Object res=ctx.lookup(name);
            resp.getWriter().append("INFO." + carInfo+"; res="+res);
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

}
