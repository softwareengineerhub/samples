/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noxml;

import com.common.Person;
import javax.sql.DataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 *
 * @author prokopiukd
 */
public class Application {

    public static void main(String[] args) {
        DataSource ds = new PersonDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, ds);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(PersonMapper.class);
        SqlSessionFactory sessionFactory = new DefaultSqlSessionFactory(configuration);
        try (SqlSession session = sessionFactory.openSession();) {
            PersonMapper personMapper = session.getMapper(PersonMapper.class);
            Person person = personMapper.selectPerson(1);
            System.out.println("person=" + person);
        }
    }

}
