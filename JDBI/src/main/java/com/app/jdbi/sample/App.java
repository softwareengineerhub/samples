/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.jdbi.sample;

import com.app.jdbc.Person;
import java.util.List;
import java.util.Map;
import org.skife.jdbi.v2.BaseResultSetMapper;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

/**
 *
 * @author prokopiukd
 */
public class App {

    public static void main(String[] args) {
        DBI dbi = new DBI("jdbc:mysql://localhost:3306/my_jpa?useSSL=false", "root", "11111111");
        Handle handle = dbi.open();
        handle.execute("INSERT INTO person(name, age) values(?,?)", "Denis", 30);
        List<Person> persons = handle.createQuery("SELECT * from person where name = :name").bind("name", "Denis").map(new BaseResultSetMapper<Person>() {

            @Override
            protected Person mapInternal(int i, Map<String, Object> map) {
                Person p = new Person();
                p.setAge((int) map.get("age"));
                p.setName("" + map.get("name"));
                return p;
            }
            
        }).list();
        for(Person p: persons){
            System.out.println(p);
        }
    }

}
