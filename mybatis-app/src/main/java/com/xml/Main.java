/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xml;

import com.common.Person;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author prokopiukd
 */
public class Main {

    public static void main(String[] args) throws IOException {
        try (InputStream in = Main.class.getResourceAsStream("/org/mybatis/example/mybatis-config.xml");) {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            try(SqlSession session=sessionFactory.openSession();){
                Person person = session.selectOne("selectPerson", 2);
                System.out.println(person);
            }
        }
    }

}
