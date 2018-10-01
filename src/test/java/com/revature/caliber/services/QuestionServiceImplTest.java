package com.revature.caliber.services;

import com.revature.caliber.Application;
import com.revature.caliber.beans.Bucket;
import com.revature.caliber.beans.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Question Tests using JUnit
 *
 * @author Omar Guzman | 1807-QC | Emily Higgins
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
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
		Question question = new Question();

		question.setQuestionId(99999);
		question.setIsActive(true);
		boolean activeBefore = question.getIsActive();
		questionService.create(question);

		question.setIsActive(false);
		questionService.updateQuestion(question);
		List<Question> qList = questionService.getAllQuestions();

		for (int i = 0; i < qList.size(); i++)
			if (question.getQuestionId() == qList.get(i).getQuestionId())
				question = qList.get(i);

		boolean activeAfter = question.getIsActive();

		assertEquals(activeBefore, !activeAfter);
	}

	@Test
	public void testToggleQuestionStatus() {
		Question question = new Question();
		question.setIsActive(false);
		question = questionService.create(question);
		questionService.toggleQuestionStatus(question.getQuestionId());
		assertTrue(questionService.getByQustionId(question.getQuestionId()).getIsActive());
	}
}