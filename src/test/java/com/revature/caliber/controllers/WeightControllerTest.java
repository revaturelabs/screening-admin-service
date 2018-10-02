package com.revature.caliber.controllers;

import com.revature.caliber.Application;
import com.revature.caliber.beans.Bucket;
import com.revature.caliber.beans.SkillType;
import com.revature.caliber.beans.Weight;
import com.revature.caliber.services.WeightServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeightControllerTest {
	@LocalServerPort
	int port;
	@Autowired
	WeightServiceImpl weightService;
	private String host = "http://ec2-52-55-27-249.compute-1.amazonaws.com:8181";

	@Test
	public void testGetWeights() {
		given()
				.port(port)
				.when()
				.get("/weight")
				.then()
				.statusCode(200);
	}

	/**
	 * Method below is not working
	 * status code is 404 regardless of
	 * the outcome of the process
	 */

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
				.put("/weight/update")
				.then()
				.statusCode(204);
	}

	@Test
	public void testCreate() {
		Weight w = new Weight(800, 600, new SkillType(), new Bucket());
		given()
				.port(port)
				.contentType("application/json")
				.body(w)
				.when()
				.post("/weight/new")
				.then()
				.statusCode(201);


	}

	/**
	 * This method below is not working
	 * When trying to access uri weight/delete/(id),
	 * we get redirected to a white label page and
	 * test is returning 200 code -_-
	 */
	@Test
	public void testDelete() {
		given()
				.port(port)
				.when()
				.delete("/weight/delete/{weightId}", 51404)
				.then()
				.statusCode(204);
	}

}
