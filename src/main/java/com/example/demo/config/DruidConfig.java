package com.example.demo.config;

import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

   /* @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }*/
}
