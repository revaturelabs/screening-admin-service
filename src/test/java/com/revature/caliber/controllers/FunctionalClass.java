package com.revature.caliber.controllers;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class FunctionalClass {
	
	@BeforeClass
	    public static void setup() {
	        String port = System.getProperty("server.port");
	        System.out.println(port);
	        if (port == null) {
	            RestAssured.port = Integer.valueOf(8080);
	        }
	        else{
	            RestAssured.port = Integer.valueOf(port);
	        }


	        String basePath = System.getProperty("server.base");
	        if(basePath==null){
	            basePath = "/rest-garage-sample/";
	        }
	        RestAssured.basePath = basePath;

	        String baseHost = System.getProperty("server.host");
	        if(baseHost==null){
	            baseHost = "http://localhost";
	        }
	        RestAssured.baseURI = baseHost;

	    }

}
