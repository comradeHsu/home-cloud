package com.home.hourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HourseApplication.class, args);
	}
}
