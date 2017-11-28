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
public class Info {

    public static void main(String[] args) {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/my_flyway", "root", "*******");
        MigrationInfoService infoService = flyway.info();
        System.out.println("info.size=" + infoService.all().length);
        for (MigrationInfo info : infoService.all()) {
            System.out.println("-----------------------");
            System.out.println(info.getVersion());
            System.out.println(info.getDescription());
            System.out.println(info.getState());
            System.out.println("-----------------------");
        }
    }
}
