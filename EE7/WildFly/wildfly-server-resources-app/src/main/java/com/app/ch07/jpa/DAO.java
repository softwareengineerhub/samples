/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch07.jpa;

/**
 *
 * @author denys.prokopiuk
 */
public interface DAO {

    public void persist(Computer c);

    public Computer find(int id);

    public Computer update(int id, String name);

    public void remove(int id);

}
