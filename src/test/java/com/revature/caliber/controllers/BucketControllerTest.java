package com.revature.caliber.controllers;

import com.revature.caliber.Application;
import com.revature.caliber.beans.Bucket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class BucketControllerTest {

	@LocalServerPort
	private int port;

	@Test
	public void testGetConnectionToBucketEndpoint() {
		given()
				.port(port)
				.when()
				.get("/bucket")
				.then()
				.log()
				.ifValidationFails()
				.statusCode(200);

	}

	@Test
	public void testGetBucketByBucketId() {
		given()
				.port(port)
				.when()
				.get("/bucket/{bucketId}", 404)
				.then()
				.body("bucketId", equalTo(404))
				.statusCode(200);
	}

	@Test
	public void testGetBucketByBucketIdBadId() {
		given()
				.port(port)
				.when()
				.get("/bucket/{bucketId}", -1)
				.then()
				.statusCode(404);
	}

	@Test
	public void testCreateBucket() {
		Bucket b = new Bucket(417, "Rest Assured Test Bucket", true);

		given()
				.port(port)
				.contentType("application/json")
				.body(b)
				.when()
				.post("/bucket")
				.then()
				.statusCode(201);
	}

	@Test
	public void testCreateBucketBadData() {
		Bucket b = new Bucket(4321890, "", false);

		given()
				.port(port)
				.contentType("application/json")
				.body(b)
				.when()
				.post("/bucket")
				.then()
				.statusCode(415);
	}

	@Test
	public void testUpdateBucket() {
		Bucket b = new Bucket(1, "Updated Rest Assured Test", true);

		given()
				.port(port)
				.contentType("application/json")
				.body(b)
				.when()
				.put("/bucket/update")
				.then()
				.statusCode(200);
	}

	@Test
	public void testDeleteBucket() {
		given()
				.port(port)
				.when()
				.delete("/bucket/{bucketId}", 404)
				.then()
				.statusCode(204);
	}


	@Test
	public void testCreateEmptyBucket() {
		Bucket b = new Bucket();
		given()
				.port(port)
				.body(b)
				.when()
				.post("/bucket")
				.then()
				.statusCode(415);
	}


}
