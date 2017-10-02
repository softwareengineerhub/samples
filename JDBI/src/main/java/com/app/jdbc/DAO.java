/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.jdbc;

import java.util.List;

/**
 *
 * @author prokopiukd
 */
public interface DAO {
    
    public List<Person> getAll();
    
}
