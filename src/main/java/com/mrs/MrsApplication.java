package com.mrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author kiran
 */
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class MrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrsApplication.class, args);
	}
}
