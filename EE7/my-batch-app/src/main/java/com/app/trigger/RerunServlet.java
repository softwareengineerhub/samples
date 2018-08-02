package com.app.trigger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denys.prokopiuk
 */
@WebServlet(urlPatterns = {"/RerunServlet"})
public class RerunServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        long id=Long.parseLong(req.getParameter("id"));
        //Long executionId = jobOperator.start("SampleJob", new Properties());
        JobExecution jobExecution = jobOperator.getJobExecution(id);
        jobOperator.restart(id, new Properties());
        System.out.println("BatchStatus : " + jobExecution.getBatchStatus());
    }

   

}
