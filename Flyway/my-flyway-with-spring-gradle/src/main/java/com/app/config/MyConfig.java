package com.app.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MyConfig {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    //dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUsername("user");
    dataSource.setPassword("11111111");
    dataSource.setUrl("jdbc:postgresql://127.0.0.1:5441/mydb");
    return dataSource;
  }

}
