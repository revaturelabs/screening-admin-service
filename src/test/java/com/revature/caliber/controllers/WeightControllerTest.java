package com.revature.caliber.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.caliber.Application;
import com.revature.caliber.beans.Weight;
import com.revature.caliber.services.WeightServiceImpl;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class WeightControllerTest {
	private String host = "http://ec2-52-55-27-249.compute-1.amazonaws.com:8181";
	
	@Autowired
	WeightServiceImpl weightService;

	@Test
	public void testGetWeights() {
		given()
		.when()
			.get(host+"/weight")
		.then()
			.statusCode(200);
	}

	@Test
	public void testGetWeightFromId() {
		given()
		.when()
			.get(host + "/weight/{weightId}", 51404)
		.then()
			.statusCode(200);
	}



	@Test
	public void testUpdateWeight() {
	Weight w = weightService.get(51404);
	w.setWeightValue(500);
		
		given()
			.contentType("application/json")
			.body(w)
		.when()
			.put(host + "/weight/update")
		.then()
			.statusCode(204);
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
