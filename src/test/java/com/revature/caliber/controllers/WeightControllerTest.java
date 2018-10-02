package com.revature.caliber.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.caliber.Application;
import com.revature.caliber.beans.Bucket;
import com.revature.caliber.beans.SkillType;
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

	/**Method below is not working
	status code is 404 regardless of
	the outcome of the process*/
	
	@Test
	public void testGetWeightFromId() {
		given()
		.when()
			.get(host + "/weight/{weightId}", 51404)
		.then()
			.statusCode(200);
	}
	@Test
	public void testGetNotExistingWeightFromId() {
		given()
		.when()
		.get(host + "/weight/{weightId}", -1)
		.then()
		.statusCode(404);
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
		Weight w = new Weight(800, 600, new SkillType(), new Bucket());
		given().
			contentType("application/json")
			.body(w)
		.when()
			.post(host+"/weight/new")
		.then()
			.statusCode(201);
		
		
	}

	/**This method below is not working
	When trying to access uri weight/delete/(id), 
	we get redirected to a white label page and 
	test is returning 200 code -_- */
	@Test
	public void testDelete() {
		given()
		.when()
			.delete(host + "/weight/delete/{weightId}", 51404)
		.then()
			.statusCode(204);
	}

}
