package com.rishabh.departments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class DepartmentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentsApplication.class, args);
	}

}
