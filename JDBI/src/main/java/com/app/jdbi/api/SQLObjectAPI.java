/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.jdbi.api;

import com.app.jdbc.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.skife.jdbi.v2.BeanMapper;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author prokopiukd
 */
public class SQLObjectAPI {
    
    public static void main(String[] args) {
        DBI dbi = new DBI("jdbc:mysql://localhost:3306/my_jpa", "root", "ManchesterCity15");
        PersonDAO dao = dbi.open(PersonDAO.class);
        dbi.registerMapper(new ResultSetMapper<Person>() {
            @Override
            public Person map(int i, ResultSet rs, StatementContext sc) throws SQLException {
                Person p = new Person();
                p.setAge(rs.getInt("age"));
                p.setName(rs.getString("name"));
                return p;
            }
        });
        dao.insert(27, "Boris");
        Person piterPerson = new Person();
        piterPerson.setAge(45);
        piterPerson.setName("Piter");
        dao.insertPerson(piterPerson);
        Person person = dao.findPeronsById(7);
        System.out.println("person by id=" + person);
        List<String> names = dao.findNamesByAge(30);
        for (String s : names) {
            System.out.println(s);
        }
        List<Person> persons = dao.findPeronsByAge(30);
        for(Person p: persons){
            System.out.println(p);
        }
        dao.close();
        
        
    }
    
}
