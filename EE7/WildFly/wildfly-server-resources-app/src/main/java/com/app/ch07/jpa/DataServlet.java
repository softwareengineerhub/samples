/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch07.jpa;

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
@WebServlet(name = "DataServlet", urlPatterns = {"/DataServlet"})
public class DataServlet extends HttpServlet {

    @EJB
    private DAO dao;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println("action="+action);
        if ("persist".equals(action)) {
            System.out.println("@Before persist");
            String name = req.getParameter("name");
            int price = Integer.parseInt(req.getParameter("price"));
            Computer c = new Computer();
            c.setName(name);
            c.setPrice(price);
            dao.persist(c);
            System.out.println("@After find");
        } else if ("find".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Computer c = dao.find(id);
            System.out.println(c);
            System.out.println("@After find");
        } else if("qqq".equals(action)){
            
        }
    }

}
