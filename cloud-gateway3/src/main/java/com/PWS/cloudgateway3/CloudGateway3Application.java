package com.PWS.cloudgateway3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class CloudGateway3Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudGateway3Application.class, args);
	}

}
