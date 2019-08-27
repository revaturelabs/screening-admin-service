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
				.get("/question")
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
	public void testGetBucketQuestionsFail() {
		given()
				.port(port)
				.when()
				.get("/question/getByBucket/{bucketId}", -2)
				.then()
				.statusCode(404);
	}


	@Test
	public void testCreate() {
		Question question = new Question(99999, null, false, "Test", "Test");

		given()
				.port(port)
				.contentType("application/json")
				.body(question)
				.when()
				.post("/question")
				.then()
				.statusCode(201);
	}

	@Test
	public void testUpdateQuestion() {
		Question question = new Question(10007, null, false, "Test", "Test");

		given()
				.port(port)
				.contentType("application/json")
				.body(question)
				.when()
				.put("/question/{bucketId}", 10007)
				.then()
				.statusCode(200);
	}
	
	@Test
	public void testUpdateQuestionBadId() {
		Question question = new Question(10007, null, false, "Test", "Test");

		given()
				.port(port)
				.contentType("application/json")
				.body(question)
				.when()
				.put("/question/{bucketId}", -1)
				.then()
				.statusCode(400);
	}

	@Test
	public void testDeleteByQuestionId() {
		given()
				.port(port)
				.when()
				.delete("/question/{id}", 10008)
				.then()
				.statusCode(200);
	}
	
	@Test
	public void testDeleteByQuestionBadId() {
		given()
				.port(port)
				.when()
				.delete("/question/{id}", -2)
				.then()
				.statusCode(400);
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
	
	@Test
	public void deleteByBucket() {
		given()
				.port(port)
				.when()
				.delete("/question/deleteByBucket/{bucketId}", 410)
				.then()
				.statusCode(200);
	}
	
	@Test
	public void testDeleteByBucketFail() {
		given()
				.port(port)
				.when()
				.delete("/question/deleteByBucket/{bucketId}", 4061)
				.then()
				.statusCode(404);
	}

}
