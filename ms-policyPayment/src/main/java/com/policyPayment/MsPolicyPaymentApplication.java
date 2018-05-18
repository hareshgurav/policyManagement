package com.policyPayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
@ComponentScan("com.policyPayment")
@SpringBootApplication
public class MsPolicyPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPolicyPaymentApplication.class, "--debug");
	}
}
