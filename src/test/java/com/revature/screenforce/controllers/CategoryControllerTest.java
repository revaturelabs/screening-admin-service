package com.revature.screenforce.controllers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Category;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class CategoryControllerTest {

	@LocalServerPort
	private int port;

	@Test
	public void testGetConnectionToCategoryEndpoint() {
		given()
			.port(port)
			.when()
			.get("/category")
			.then()
			.log()
			.ifValidationFails()
			.statusCode(200);
	}

	@Test
	public void testGetCategoryByCategoryId() {
		given()
			.port(port)
			.when()
			.get("/category/{categoryId}", 404)
			.then()
			.body("categoryId", equalTo(404))
			.statusCode(200);
	}

	@Test
	public void testGetCategoryByCategoryIdBadId() {
		given()
			.port(port)
			.when()
			.get("/category/{categoryId}", -1)
			.then()
			.statusCode(404);
	}

	@Test
	public void testCreateCategory() {
		Category b = new Category(417, "Rest Assured Test Category", true);

		given()
			.port(port)
			.contentType("application/json")
			.body(b).when()
			.post("/category")
			.then()
			.statusCode(201);
	}

	@Test
	public void testCreateCategoryBadData() {
		Category b = new Category(4321890, "", false);

		given()
			.port(port)
			.contentType("application/json")
			.body(b)
			.when()
			.post("/category")
			.then()
			.statusCode(415);
	}

	@Test
	public void testUpdateCategory() {
		Category b = new Category(404, "Updated Rest Assured Test", true);

		given()
			.port(port)
			.contentType("application/json")
			.body(b)
			.when()
			.put("/category/404")
			.then()
			.statusCode(200);
	}

	@Test
	public void testUpdateCategoryFail() {
		Category b = new Category(1, "Updated Rest Assured Test", true);

		given()
			.port(port)
			.contentType("application/json")
			.body(b)
			.when()
			.put("/category/1")
			.then()
			.statusCode(400);
	}

	@Test
	public void testDeleteCategory() {
		given()
			.port(port)
			.when()
			.delete("/category/{categoryId}", 404)
			.then()
			.statusCode(204);
	}

	@Test
	public void testDeleteCategoryFail() {
		given()
			.port(port)
			.when()
			.delete("/category/{categoryId}", 4014)
			.then()
			.statusCode(404);
	}

	@Test
	public void testCreateEmptyCategory() {
		Category b = new Category();
		given()
			.port(port)
			.body(b)
			.when()
			.post("/category")
			.then()
			.statusCode(415);
	}
}
