package com.revature.caliber.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import com.revature.caliber.Application;
import static io.restassured.RestAssured.*;
import org.springframework.test.context.junit4.SpringRunner;
import com.revature.caliber.beans.Bucket;
import com.revature.caliber.beans.Question;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class QuestionControllerTest {
	
	private final String url="http://ec2-52-55-27-249.compute-1.amazonaws.com:8181";

	@Test
	public void testGetQuestions() {
		given()
		.when()
			.get(url + "/question/all")
		.then()
			.statusCode(200);
	}

	@Test
	public void testGetBucketQuestions() {
		given()
		.when()
			.get(url + "/question/getByBucket/{bucketId}", 404)
		.then()
			.statusCode(200);
	}

	@Test
	public void testDeleteByBucket() {
		given()
	       .when().delete(url + "/question/deleteByBucket/" + 404)
	       .then().log().ifError()
	       .assertThat().statusCode(204);
	}

	@Test
	public void testCreate() {
		//fail("Not yet implemented");
		Question question = new Question(99999, new Bucket(), false, "Test", "Test", "Test", "Test", "Test", "Test");
		
		given()
			.contentType("application/json")
			.body(question)
		.when()
			.post(url + "/question/new")
		.then()
			.statusCode(201);
	}

	@Test
	public void testUpdateQuestion() {
		Question question = new Question(1007, new Bucket(), false, "Test", "Test", "Test", "Test", "Test", "Test");
		
		given()
			.contentType("application/json")
			.body(question)
		.when()
			.put(url + "/question/update")
		.then()
			.statusCode(200);
	}

	@Test
	public void testDeleteByQuestionId() {
		int questionId = 1007;
		
		given()
		.when()
			.delete(url + "/question/deleteByBucket/{bucketId}" , questionId)
		.then()
			.statusCode(204);
	}

	@Test
	public void testActivateQuestion() {
		//fail("Not yet implemented");
		int questionId = 1007;
		given()
	       .when().put(url + "/question/toggle/" + questionId)
	       .then().log().ifError()
	       .assertThat().statusCode(204);
	}

}
