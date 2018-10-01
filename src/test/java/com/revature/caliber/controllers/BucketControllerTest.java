package com.revature.caliber.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.caliber.Application;
import com.revature.caliber.beans.Bucket;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BucketControllerTest{

	private String host = "http://ec2-52-55-27-249.compute-1.amazonaws.com:8181";
	
	@Test
	public void testGetConnectionToBucketEndpoint() {
		given()
		.when()
			.get(host + "/bucket")
		.then()
			.log()
			.ifValidationFails()
			.statusCode(200);
			
	}

	@Test
	public void testGetBucketByBucketId() {
		given()
		.when()
			.get(host + "/bucket/{bucketId}", 404)
		.then()
			.body("bucketId", equalTo(404))
			.statusCode(200);
	}
	
	@Test
	public void testCreateBucket() {
		Bucket b = new Bucket(417, "Rest Assured Test Bucket", true);
		
		given()
			.contentType("application/json")
			.body(b)
		.when()
			.post(host + "/bucket")
		.then()
			.statusCode(201);
	}

	@Test
	public void testUpdateBucket() {
		fail("Not yet implemented");
	}

	/*
	@Test
	public void testDeleteBucket() {
		fail("Not yet implemented");
	}*/

}
