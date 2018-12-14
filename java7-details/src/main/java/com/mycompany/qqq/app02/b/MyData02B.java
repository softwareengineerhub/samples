/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qqq.app02.b;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyData02B implements InterC, InterD {

    @Override
    public void doAction() throws MySubChildException {
        System.out.println("MyData02B.doAction()");
    }

}
