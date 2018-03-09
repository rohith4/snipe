package com.snipe.community;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.zaxxer.hikari.HikariDataSource;



@SpringBootApplication
public class Autowired3Application {

	public static void main(String[] args) {
		SpringApplication.run(Autowired3Application.class, args);
	}
	
}
