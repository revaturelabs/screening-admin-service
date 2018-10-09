package com.revature.caliber.controllers;

import com.revature.caliber.Application;
import com.revature.caliber.beans.SkillType;
import com.revature.caliber.services.SkillTypeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Tests for the SkillType Controller
 *
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class SkillTypeControllerTest {

	@Autowired
	SkillTypeServiceImpl skillType;
	@LocalServerPort
	private int port;
	private String host = "http://localhost:" + port;

	@Test
	public void testGetSkills() {
		given()
				.port(port)
				.when()
				.get("/skilltype")
				.then()
				.statusCode(200);
	}

	@Test
	public void testGetActiveSkills() {
		given()
				.port(port)
				.when()
				.get("/skilltype/active")
				.then()
				.statusCode(200);
	}

	@Test
	public void testGetSkillById() {
		given()
				.port(port)
				.when()
				.get("/skilltype/{id}", 51)
				.then()
				.body("skillTypeId", equalTo(51))
				.statusCode(200);
	}


	@Test
	public void testGetSkillByIdForIdThatDoesNotExist() {
		given()
				.port(port)
				.when()
				.get("/skilltype/{id}", -1)
				.then()
				.statusCode(404);
	}

	@Test
	public void testCreateSkill() {
		SkillType st = new SkillType("Charisma", true);

		given()
				.port(port)
				.contentType("application/json")
				.body(st)
				.when()
				.post("/skilltype")
				.then()
				.statusCode(201);
	}

	@Test
	public void testCreateSkillWithoutTitle() {
		SkillType st = new SkillType("", true);

		given()
				.port(port)
				.contentType("application/json")
				.body(st)
				.when()
				.post("/skilltype")
				.then()
				.statusCode(406);
	}

	@Test
	public void testUpdateSkillById() {
		SkillType st = skillType.getSkillType(51);
		st.setTitle("Updated SkillType");

		given()
				.port(port)
				.contentType("application/json")
				.body(st)
				.when()
				.put("/skilltype/{id}", 51)
				.then()
				.statusCode(202);
	}


	@Test
	public void testDeleteSkillById() {
		given()
				.port(port)
				.when()
				.delete("/skilltype/{id}", 56)
				.then()
				.statusCode(204);
	}

	@Test
	public void testDeleteSkillByIdForIdThatDoesNotExist() {
		given()
				.port(port)
				.when()
				.delete("/skilltype/{id}", -1)
				.then()
				.statusCode(404);
	}

}
