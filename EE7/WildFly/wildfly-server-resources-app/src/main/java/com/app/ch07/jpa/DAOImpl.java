/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ch07.jpa;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author denys.prokopiuk
 */
@Stateless
public class DAOImpl implements DAO {

    /*@Resource
    private PersistenceUnit persistenceUnit;    */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persist(Computer c) {
        System.out.println("entityManager="+entityManager);
        System.out.println("computer="+c);
        entityManager.persist(c);
    }

    @Override
    public Computer find(int id) {
        return entityManager.find(Computer.class, id);
    }

    @Override
    public Computer update(int id, String name) {
        Computer old = entityManager.find(Computer.class, id);
        return entityManager.merge(old);
    }

    @Override
    public void remove(int id) {
        Computer c = entityManager.find(Computer.class, id);
        entityManager.remove(c);
    }

}
