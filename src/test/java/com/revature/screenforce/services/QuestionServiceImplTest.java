package com.revature.screenforce.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.beans.Question;
import com.revature.screenforce.services.BucketServiceImpl;
import com.revature.screenforce.services.QuestionServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Question Tests using JUnit
 *
 * @author Omar Guzman | 1807-QC | Emily Higgins
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class QuestionServiceImplTest {

	@Autowired
	QuestionServiceImpl questionService;

	@Autowired
	BucketServiceImpl bucketService;

	@Test
	public void testCreate() {
		Question question = new Question();
		question.setQuestionId(99999);
		int before = questionService.getAllQuestions().size();
		questionService.create(question);
		int after = questionService.getAllQuestions().size();

		assertEquals(before + 1, after);
	}

	@Test
	public void testGetAllQuestions() {
		int before = questionService.getAllQuestions().size();
		assertEquals(before, questionService.getAllQuestions().size());
	}

	@Test
	public void testGetQuestionsByBucket() {
		Question question1 = questionService.create(new Question());
		Question question2 = questionService.create(new Question());
		Bucket bucket = new Bucket(99999, "Test Bucket", false);
		bucket = bucketService.createBucket(bucket);

		question1.setBucket(bucket);
		question2.setBucket(bucket);

		questionService.updateQuestion(question1);
		questionService.updateQuestion(question2);

		int qListSize = questionService.getQuestionsByBucket(bucket.getBucketId()).size();

		assertEquals(2, qListSize);
	}

	@Test
	public void testDeleteByQuestionId() {
		Question question = new Question();
		int before = questionService.getAllQuestions().size();
		question = questionService.create(question);
		int after = questionService.getAllQuestions().size();
		questionService.deleteByQuestionId(question.getQuestionId());

		assertEquals(before, after - 1);
	}

	@Test
	public void testUpdateQuestion() {
		Question question = new Question(50, null, false, "Question Test Before", "Test", "Test", "Test", "Test", "Test");
		question = questionService.create(question);
		String updateText = "Question Test After";
		question.setQuestionText(updateText);
		question = questionService.updateQuestion(question);
		assertEquals(updateText,question.getQuestionText());
	}

	@Test
	public void testToggleQuestionStatus() {
		Question question = new Question();
		question.setIsActive(false);
		question = questionService.create(question);
		questionService.toggleQuestionStatus(question.getQuestionId());
		assertTrue(questionService.getByQuestionId(question.getQuestionId()).getIsActive());
	}
	
	@Test
	public void testDeleteByBucketId() {
		int total = questionService.getAllQuestions().size();
		questionService.deleteByBucketId(406);
		int after = questionService.getAllQuestions().size();
		assertEquals((total-3), after);
	}
}
