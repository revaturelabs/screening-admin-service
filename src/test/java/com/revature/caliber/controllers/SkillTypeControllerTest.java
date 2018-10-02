package com.revature.caliber.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.caliber.Application;
import com.revature.caliber.beans.SkillType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * Tests for the SkillType Controller
 * 
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SkillTypeControllerTest {

	private String host = "http://ec2-52-55-27-249.compute-1.amazonaws.com:8181";
	
	@Test
	public void testGetSkills() {
		given()
		.when()
			.get(host + "/skilltype")
		.then()
			.statusCode(200);
	}

	@Test
	public void testGetActiveSkills() {
		given()
		.when()
			.get(host + "/skilltype/active")
		.then()
			.statusCode(200);
	}

	@Test
	public void testGetSkillById() {
		given()
		.when()
			.get(host + "/skilltype/{id}", 51)
		.then()
			.body("skillTypeId", equalTo(51))
			.statusCode(200);
	}

	@Test
	public void testCreateSkill() {
		SkillType st = new SkillType("Charisma", true);
		
		given()
			.contentType("application/json")
			.body(st)
		.when()
			.post(host + "/skilltype")
		.then()
			.statusCode(201);
	}
	
	@Test
	public void testCreateSkillWithoutTitle() {
		SkillType st = new SkillType("", true);
		
		given()
			.contentType("application/json")
			.body(st)
		.when()
			.post(host + "/skilltype")
		.then()
			.statusCode(406);
	}

	@Test
	public void testUpdateSkillById() {
		SkillType st = new SkillType("Test Update", true);
		
		given()
			.contentType("application/json")
			.body(st)
		.when()
			.put(host + "/skilltype/{id}", 51)
		.then()
			.statusCode(202);
	}

	@Test
	public void testUpdateSkillByIdForIdThatDoesNotExist() {
		SkillType st = new SkillType("Test Update", true);
		
		given()
			.contentType("application/json")
			.body(st)
		.when()
			.put(host + "/skilltype/{id}", -1)
		.then()
			.statusCode(404);
	}
	
	@Test
	public void testDeleteSkillById() {
		given()
		.when()
			.delete(host + "/skilltype/{id}" , 56)
		.then()
			.statusCode(204);
	}
	
	@Test
	public void testDeleteSkillByIdForIdThatDoesNotExist() {
		given()
		.when()
			.delete(host + "/skilltype/{id}" , -1)
		.then()
			.statusCode(404);
	}

}
