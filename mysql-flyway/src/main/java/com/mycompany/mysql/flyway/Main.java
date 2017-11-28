/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mysql.flyway;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.MigrationInfoService;

/**
 *
 * @author prokopiukd
 */
public class Main {

    public static void main(String[] args) {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/my_flyway", "root", "*******");
        int result = flyway.migrate();
        System.out.println("result=" + result);
    }
}
