package com.oracle.policymgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsPolicyEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPolicyEurekaServerApplication.class, args);
	}
}
