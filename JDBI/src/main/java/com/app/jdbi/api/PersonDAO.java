/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.jdbi.api;

import com.app.jdbc.Person;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 *
 * @author prokopiukd
 */
@RegisterMapper(PersonMapper.class)
public interface PersonDAO {

    @SqlUpdate("insert into person(age, name) values(:age, :name)")
    public void insert(@Bind("age") int age, @Bind("name") String name);

    @SqlUpdate("insert into person(age, name) values(:p.age, :p.name)")
    public void insertPerson(@BindBean("p") Person person);

    @SqlQuery("select name from person where age = :age")
    public List<String> findNamesByAge(@Bind("age") int age);

    @SqlQuery("select * from person where age = :age")
    public List<Person> findPeronsByAge(@Bind("age") int age);

    //@Mapper(PersonMapper.class)
    @SqlQuery("select * from person where age = :id")
    public Person findPeronsById(@Bind("id") int id);

    public void close();

}
