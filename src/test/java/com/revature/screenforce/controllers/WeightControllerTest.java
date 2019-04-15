package com.revature.screenforce.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Weight;
import com.revature.screenforce.services.WeightServiceImpl;

import static io.restassured.RestAssured.given;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class WeightControllerTest {
	@LocalServerPort
	int port;

	@Autowired
	WeightServiceImpl weightService;

	@Test
	public void testGetWeights() {
		given()
				.port(port)
				.when()
				.get("/weight")
				.then()
				.statusCode(200);
	}

	@Test
	public void testGetWeightFromId() {
		given()
				.port(port)
				.when()
				.get("/weight/{weightId}", 51404)
				.then()
				.statusCode(200);
	}

	@Test
	public void testGetNotExistingWeightFromId() {
		given()
				.port(port)
				.when()
				.get("/weight/{weightId}", -1)
				.then()
				.statusCode(404);
	}


	@Test
	public void testUpdateWeight() {
		Weight w = weightService.get(51404);
		w.setWeightValue(500);
		given()
				.port(port)
				.contentType("application/json")
				.body(w)
				.when()
				.put("/weight/{weightId}", 51404)
				.then()
				.statusCode(204);
	}
	
	@Test
	public void testUpdateWeightFail() {
		Weight w = weightService.get(51404);
		w.setWeightValue(500);
		given()
				.port(port)
				.contentType("application/json")
				.body(w)
				.when()
				.put("/weight/{weightId}", -1)
				.then()
				.statusCode(404);
	}

	@Test
	public void testCreate() {
		Weight w = new Weight(800, 600, null, null);
		given()
				.port(port)
				.contentType("application/json")
				.body(w)
				.when()
				.post("/weight")
				.then()
				.statusCode(201);
	}

	@Test
	public void testDelete() {
		given()
				.port(port)
				.when()
				.delete("/weight/{weightId}", 51404)
				.then()
				.statusCode(204);
	}
	
	@Test
	public void testDeleteBadId() {
		given()
				.port(port)
				.when()
				.delete("/weight/{weightId}", -1)
				.then()
				.statusCode(404);
	}

	@Test
	public void testGetBySkillTypeAndWeight() {
		given()
				.port(port)
				.when()
				.get("/weight/{skillTypeId}/{bucketId}", 51, 404)
				.then()
				.statusCode(200);
	}

	@Test
	public void testGetWeightBySkillType() {
		given()
				.port(port)
				.when()
				.get("/weight/getBySkillType/{skillTypeId}", 51)
				.then()
				.statusCode(200);
	}
}
