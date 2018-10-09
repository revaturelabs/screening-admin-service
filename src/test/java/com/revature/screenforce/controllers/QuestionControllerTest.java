package com.revature.screenforce.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Question;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class QuestionControllerTest {

	@LocalServerPort
	int port;

	@Test
	public void testGetQuestions() {
		given()
				.port(port)
				.when()
				.get("/question/all")
				.then()
				.statusCode(200);
	}

	@Test
	public void testGetBucketQuestions() {
		given()
				.port(port)
				.when()
				.get("/question/getByBucket/{bucketId}", 404)
				.then()
				.statusCode(200);
	}

	@Test
	public void testDeleteByBucket() {
		given()
				.port(port)
				.when().delete("/question/deleteByBucket/{bucketId}", 404)
				.then().log().ifError()
				.assertThat().statusCode(204);
	}

	@Test
	public void testCreate() {
		Question question = new Question(99999, null, false, "Test", "Test", "Test", "Test", "Test", "Test");

		given()
				.port(port)
				.contentType("application/json")
				.body(question)
				.when()
				.post("/question/new")
				.then()
				.statusCode(201);
	}

	@Test
	public void testUpdateQuestion() {
		Question question = new Question(1007, null, false, "Test", "Test", "Test", "Test", "Test", "Test");

		given()
				.port(port)
				.contentType("application/json")
				.body(question)
				.when()
				.put("/question/update")
				.then()
				.statusCode(200);
	}

	@Test
	public void testDeleteByQuestionId() {
		int questionId = 1008;

		given()
				.port(port)
				.when()
				.delete("/question/delete/{id}", questionId)
				.then()
				.statusCode(200);
	}

	@Test
	public void testActivateQuestion() {
		int questionId = 1007;

		given()
				.port(port)
				.when()
				.put("/question/toggle/" + questionId)
				.then()
				.log()
				.ifError()
				.assertThat()
				.statusCode(204);
	}

	@Test
	public void testGetQuestionById() {
		given()
				.port(port)
				.when()
				.get("/question/{questionId}", 10010)
				.then()
				.log()
				.ifError()
				.assertThat()
				.statusCode(200);
	}

	@Test
	public void testGetQuestionBadId() {
		given()
				.port(port)
				.when()
				.get("/question/{questionId}", -1)
				.then()
				.assertThat()
				.statusCode(404);
	}
}
