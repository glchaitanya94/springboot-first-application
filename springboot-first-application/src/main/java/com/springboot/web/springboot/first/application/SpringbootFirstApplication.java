package com.springboot.web.springboot.first.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*springBoot is on top of spring */

@SpringBootApplication
public class SpringbootFirstApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootFirstApplication.class, args);
	}
}

/* meta
 * groupId - always less than 3 dots
 * artifact id - always project name
 * 
 * 
 * mockito needs spring version more than 2.0
 */