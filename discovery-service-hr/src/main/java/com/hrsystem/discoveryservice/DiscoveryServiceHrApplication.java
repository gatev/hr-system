package com.hrsystem.discoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceHrApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceHrApplication.class, args);
	}

}
