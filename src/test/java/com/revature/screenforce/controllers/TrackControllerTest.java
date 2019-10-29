package com.revature.screenforce.controllers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Track;
import com.revature.screenforce.services.TrackServiceImpl;

/**
 * Tests for the Track Controller
 *
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class TrackControllerTest {

	@Autowired
	TrackServiceImpl track;
	@LocalServerPort
	private int port;

	@Test
	public void testGetSkills() {
		given()
			.port(port)
			.when()
			.get("/track")
			.then()
			.statusCode(200);
	}

	@Test
	public void testGetActiveSkills() {
		given()
			.port(port)
			.when()
			.get("/track/active")
			.then()
			.statusCode(200);
	}

	@Test
	public void testGetSkillById() {
		given()
			.port(port)
			.when()
			.get("/track/{id}", 51)
			.then()
			.body("trackId", equalTo(51))
			.statusCode(200);
	}


	@Test
	public void testGetSkillByIdForIdThatDoesNotExist() {
		given()
			.port(port)
			.when()
			.get("/track/{id}", -1)
			.then()
			.statusCode(404);
	}

	@Test
	public void testCreateSkill() {
		Track st = new Track("Charisma", true);

		given()
			.port(port)
			.contentType("application/json")
			.body(st)
			.when()
			.post("/track")
			.then()
			.statusCode(201);
	}

	@Test
	public void testCreateSkillWithoutTitle() {
		Track st = new Track("", true);

		given()
			.port(port)
			.contentType("application/json")
			.body(st)
			.when()
			.post("/track")
			.then()
			.statusCode(406);
	}

	@Test
	public void testUpdateSkillById() {
		Track st = track.getTrack(51);
		st.setTitle("Updated Track");

		given()
			.port(port)
			.contentType("application/json")
			.body(st)
			.when()
			.put("/track/{id}", 51)
			.then()
			.statusCode(202);
	}

	@Test
	public void testUpdateSkillBadId() {
		Track st = track.getTrack(51);
		st.setTitle("Updated Track");
		
		given()
			.port(port)
			.contentType("application/json")
			.body(st)
			.when()
			.put("/track/{id}", -1)
			.then()
			.statusCode(404);
	}

	@Test
	public void testDeleteSkillById() {
		given()
			.port(port)
			.when()
			.delete("/track/{id}", 52)
			.then()
			.statusCode(204);
	}

	@Test
	public void testDeleteSkillByIdForIdThatDoesNotExist() {
		given()
			.port(port)
			.when()
			.delete("/track/{id}", -1)
			.then()
			.statusCode(404);
	}
}
