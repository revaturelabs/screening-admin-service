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
		Bucket b = new Bucket(1, "Updated Rest Assured Test", true);
		
		given()
			.contentType("application/json")
			.body(b)
		.when()
			.put(host + "/bucket/update")
		.then()
			.statusCode(200);
	}

	@Test
	public void testDeleteBucket() {
		given()
		.when()
			.delete(host + "/bucket/{bucketId}" , 404)
		.then()
			.statusCode(204);
	}
	
	@Test
	public void testCreateNullBucket() {
		Bucket b = null;
		
		given()
			.contentType("application/json")
			.body(b)
		.when()
			.post(host + "/bucket")
		.then()
			.statusCode(403);
	}
	
	@Test
	public void testCreateEmptyBucket() {
		Bucket b = new Bucket();
		
		given()
			.contentType("application/json")
			.body(b)
		.when()
			.post(host + "/bucket")
		.then()
			.statusCode(403);
	}
}
