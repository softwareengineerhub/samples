package com.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.app"})
@ComponentScan({"com"})
public class MySpringConfiguration {

    public static void main(String[] args) {
        //System.setProperty("server.port", "8081");
        SpringApplication.run(MySpringConfiguration.class, args);
    }
}
