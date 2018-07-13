/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch01.ejb.asynch;

import java.io.IOException;
import java.util.concurrent.Future;
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
@WebServlet(name = "FutureBeanServlet", urlPatterns = {"/FutureBeanServlet"})
public class FutureBeanServlet extends HttpServlet {

    @EJB
    private FutureBean futureBean;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Future<String> result = futureBean.process("data");
            while (!result.isDone() && !result.isCancelled()) {
            }
            resp.getWriter().append(result.get());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
