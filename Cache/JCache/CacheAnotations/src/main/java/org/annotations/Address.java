/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.annotations;

import java.io.Serializable;


/**
 *
 * @author Denis
 */

public class Address implements Serializable {
    
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Address{" + "title=" + title + '}';
    }
    
    
    
}
