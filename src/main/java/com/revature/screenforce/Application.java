package com.revature.screenforce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}
	
	/**
	 * Implements Swagger2 on all end points within this service
	 *  
	 * @param DocumentationType - the version and type of documentation 
	 * @return Docket - contains information regarding end points
	 * @author Germy Louis | 1903-Tampa | Emily Higgins
	 */
	@Bean
	public Docket swag() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.revature.screenforce"))
				.paths(regex("/.*"))
				.build();
	}

	
	
}