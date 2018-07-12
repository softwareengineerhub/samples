/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.stateless.remote;

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
@WebServlet(name = "PhoneInfoInjectServlet", urlPatterns = {"/PhoneInfoInjectServlet"})
public class PhoneInfoInjectServlet extends HttpServlet {

    @EJB(beanName = "phoneInfoImpl")
    private PhoneInfo phoneInfo;
    @EJB(beanName = "phoneInfoBean")
    private PhoneInfo phoneInfoBean;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("INFO." + phoneInfo + "; " + phoneInfoBean);
    }

}
