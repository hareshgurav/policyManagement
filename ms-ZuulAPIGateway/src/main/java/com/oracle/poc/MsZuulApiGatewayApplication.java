package com.oracle.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication

public class MsZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsZuulApiGatewayApplication.class, args);
	}
}
