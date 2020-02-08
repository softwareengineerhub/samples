/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rmi.common;

import java.io.Serializable;

/**
 *
 * @author DProkopiuk
 */
public class MyServiceResponse implements Serializable {

    private String errorMessage;
    private int statusCode;
    private static final long serialVersionUID = 1L;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "MyServiceResponse{" + "errorMessage=" + errorMessage + ", statusCode=" + statusCode + '}';
    }

}
