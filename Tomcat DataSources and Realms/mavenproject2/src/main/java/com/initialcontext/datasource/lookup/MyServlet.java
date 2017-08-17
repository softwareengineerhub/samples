/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.initialcontext.datasource.lookup;

import com.model.dao.DAO;
import com.model.dao.DAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
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
@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DataSource ds=getDataSource("jdbc/TestDB");
            System.out.println("ds="+ds);
            DAO dao = new DAOImpl(ds);
            int count = dao.getCount();
            System.out.println("count="+count);
            System.out.println("count="+count);
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    private DataSource getDataSource(String dataSourceLocation) throws NamingException {
        Context ctx = new InitialContext();
        Context envContext = (Context) ctx.lookup("java:/comp/env");
        javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup(dataSourceLocation);
        return ds;
    }
}
