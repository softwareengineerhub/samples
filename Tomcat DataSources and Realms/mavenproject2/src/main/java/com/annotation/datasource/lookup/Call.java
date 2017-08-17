/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.annotation.datasource.lookup;

import com.model.dao.DAO;
import com.model.dao.DAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author prokopiukd
 */
@WebServlet(name = "Call", urlPatterns = {"/Call"})
public class Call extends HttpServlet {
    @Resource(name = "jdbc/TestDB")
    private DataSource ds;
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO dao = new DAOImpl(ds);
        int count = dao.getCount();
        System.out.println("count="+count);
    }

}
