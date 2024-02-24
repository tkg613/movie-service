package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//Without below annotation, the following error prevents Spring Boot from launching application. Why?
//Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

}
