package com.revature.screenforce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableSwagger2
@EnableZuulProxy
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}
	
}