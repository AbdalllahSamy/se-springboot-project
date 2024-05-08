package com.seproject.seproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy()
public class SeprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeprojectApplication.class, args);
	}

}
