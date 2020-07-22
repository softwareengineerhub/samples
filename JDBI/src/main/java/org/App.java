/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import com.app.jdbi.api.PersonDAO;
import org.skife.jdbi.v2.DBI;

import java.util.List;

/**
 *
 * @author prokopiukd
 */
public class App {
    
    public static void main(String[] args) {
        DBI dbi = new DBI("jdbc:mysql://localhost:3306/my_jpa?useSSL=false", "root", "11111111");
        PersonDAO dao = dbi.open(PersonDAO.class);
        List<String> list =  dao.findNamesByAge(30);
        System.out.println(list);
    }
    
}
