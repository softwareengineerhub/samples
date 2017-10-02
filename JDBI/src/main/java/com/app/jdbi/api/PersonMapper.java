/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.jdbi.api;

import com.app.jdbc.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author prokopiukd
 */
public class PersonMapper implements ResultSetMapper<Person> {

    @Override
    public Person map(int i, ResultSet rs, StatementContext sc) throws SQLException {
        Person p = new Person();
        p.setAge(rs.getInt("age"));
        p.setName(rs.getString("name"));
        return p;
    }

}
