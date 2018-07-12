/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wildfly.server.resources.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author denys.prokopiuk
 */
@WebServlet(name = "InfoServlet", urlPatterns = {"/InfoServlet"})
public class InfoServlet extends HttpServlet {

    @Resource(name = "ExampleDS")
    private DataSource ds;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.append(String.format("<H1>%s</H1><br>", ds));        
        try (Connection c = ds.getConnection()) {
            pw.append("Connected");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
