/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.annotations;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denys
 */
@WebServlet(name = "My", urlPatterns = {"/My"})
public class My extends HttpServlet {
    @Inject
    private Utils utils;    
    @Inject
    private AddressController addressController;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        utils.method();
        Address address = new Address();
        address.setTitle("A1");
        addressController.post(1, address);
        Address address1 = addressController.get(1);
        System.out.println(address1);
    }

}
