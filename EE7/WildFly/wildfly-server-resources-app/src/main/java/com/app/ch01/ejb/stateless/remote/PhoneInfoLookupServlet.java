/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.stateless.remote;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "PhoneInfoLookupServlet", urlPatterns = {"/PhoneInfoLookupServlet"})
public class PhoneInfoLookupServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InitialContext ctx = new InitialContext();
            Object res = ctx.lookup("java:module/phoneInfoImpl");
            resp.getWriter().append("INFO; res=" + res);
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

}
