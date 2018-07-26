/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.common.client;

/**
 *
 * @author denys.prokopiuk
 */
public interface APIClient {
    
    public long count();
    
    public int put();
    
    public String getJSON(String fileName);
    
}
