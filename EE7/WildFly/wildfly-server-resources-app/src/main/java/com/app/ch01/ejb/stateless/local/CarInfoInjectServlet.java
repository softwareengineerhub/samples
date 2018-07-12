/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.stateless.local;

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
@WebServlet(name = "CarInfoInjectServlet", urlPatterns = {"/CarInfoInjectServlet"})
public class CarInfoInjectServlet extends HttpServlet {

    //@EJB(name = "java:module/carInfoBean")
    @EJB(beanName = "carInfoBean")
    private CarInfo carInfo;
    @EJB(beanName = "carInfoBean")
    private CarInfo carInfo2;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("INFO." + carInfo + "; " + carInfo2);
    }

}
