package com.gcit.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.gcit.lms")
@SpringBootApplication
public class LmsSpringBootHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsSpringBootHibernateApplication.class, args);
	}
}
