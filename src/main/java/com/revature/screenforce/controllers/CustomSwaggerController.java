package com.revature.screenforce.controllers;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.json.JsonSerializer;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;
import springfox.documentation.swagger2.web.Swagger2Controller;

/**
 * Caliber's gateway service has a strip-prefix: false configuration. This allows us to
 * call endpoints from Zuul such as http://localhost:10000/users instead of /users/users.
 * 
 * This controller overrides the Swagger2Controller behavior so the home of the docs
 * changes to our specified parameter -> SWAGGER_HOME + /v2/api-docs.
 * 
 * After making this change, Caliber's gateway service will be able to display all API
 * documentations for this particular service since the path is now accessible.
 * 
 * @author Peter Alagna
 *
 */
@Controller
@ApiIgnore
@RequestMapping(value = CustomSwaggerController.SWAGGER_HOME)
public class CustomSwaggerController extends Swagger2Controller {
    
    public static final String SWAGGER_HOME = "/users/documentation";
    
    public CustomSwaggerController(Environment environment, DocumentationCache documentationCache,
            ServiceModelToSwagger2Mapper mapper, JsonSerializer jsonSerializer) {
        super(environment, documentationCache, mapper, jsonSerializer);
    }
} 