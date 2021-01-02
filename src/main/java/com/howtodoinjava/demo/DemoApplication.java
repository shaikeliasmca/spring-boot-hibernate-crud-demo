package com.howtodoinjava.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shaik
 * 
 * Code references:
 * https://howtodoinjava.com/spring-boot2/spring-boot-crud-hibernate/
 * https://www.codejava.net/frameworks/spring-boot/spring-boot-crud-example-with-spring-mvc-spring-data-jpa-thymeleaf-hibernate-mysql
 *
 * In memory Database, H2 Console url:
 * http://localhost:8080/h2/
 * 
 * Output url:
 * http://localhost:8080/employees/
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
