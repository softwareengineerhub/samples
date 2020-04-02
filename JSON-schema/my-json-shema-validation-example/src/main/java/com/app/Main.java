/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

/**
 *
 * @author asusadmin
 */
public class Main {

    public static void main(String[] args) {
        MyValidator myValidator = new MyValidator();
        myValidator.validateValid();

        try {
            myValidator.validateInvalid();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
