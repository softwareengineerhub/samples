/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch02.beanvalidation;

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
@WebServlet(name = "AccountProcessorServlet", urlPatterns = {"/AccountProcessorServlet"})
public class AccountProcessorServlet extends HttpServlet {
    @EJB
    private AccountProcessor accountProcessor;
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserAccount userAccount = new UserAccount();
        userAccount.setAge(Integer.parseInt(req.getParameter("age")));
        userAccount.setMail(req.getParameter("email"));
        userAccount.setName(req.getParameter("name"));        
        accountProcessor.process(userAccount);
    }

    
    
}
