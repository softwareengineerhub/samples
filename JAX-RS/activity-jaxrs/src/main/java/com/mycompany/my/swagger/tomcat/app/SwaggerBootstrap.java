/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.swagger.tomcat.app;

import com.wordnik.swagger.config.ConfigFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asusadmin
 */
public class SwaggerBootstrap extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) {
        try {

            ServletContext sc = servletConfig.getServletContext();

            //as of servlet api 2.5
            String ctxPath = sc.getContextPath();
            String apiversion = "your-api-version";
            String hostname = "your-hostname";

            ConfigFactory.config().setBasePath("http://" + hostname + ":8080" + ctxPath);
            ConfigFactory.config().setApiPath("http://" + hostname + ":8080" + ctxPath);
            ConfigFactory.config().setApiVersion(apiversion);
            ConfigFactory.config().setSwaggerVersion(com.wordnik.swagger.core.SwaggerSpec.version());

            System.out.println("Swagger:");
            System.out.println("api hostname:" + hostname);
            System.out.println("context path:" + ctxPath);
            System.out.println("api-version:" + apiversion);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to configure swagger");
        }
    }

}
