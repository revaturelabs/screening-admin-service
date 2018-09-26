package com.revature.caliber.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.caliber.beans.Bucket;
import com.revature.caliber.beans.Question;

/**
 * Question Tests using JUnit
 * @author Omar Guzman | 1807-QC | Emily Higgins
 * 
 */

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
		questionService.deleteByQuestionId(question.getQuestionId());
		assertEquals(before + 1, after);
	}

	@Test
	public void testGetAllQuestions() {
		int before = questionService.getAllQuestions().size();
		assertEquals(before, questionService.getAllQuestions().size());
	}

	@Test
	public void testGetQuestionsByBucket() {
		Question question1 = new Question();
		Question question2 = new Question();
		Bucket bucket = new Bucket(99999, "Test Bucket", false);

		question1.setQuestionId(99999);
		question2.setQuestionId(99998);
		
		question1.setBucket(bucket);
		question2.setBucket(bucket);

		bucketService.createBucket(bucket);
		questionService.create(question1);
		questionService.create(question2);
		int qListSize = questionService.getQuestionsByBucket(bucket.getBucketId()).size();

		bucketService.deleteBucket(bucket.getBucketId());
		questionService.deleteByQuestionId(question1.getQuestionId());
		questionService.deleteByQuestionId(question2.getQuestionId());

		assertEquals(2, qListSize);
	}

	@Test
	public void testDeleteByQuestionId() {
		Question question = new Question();
		question.setQuestionId(99999);
		int before = questionService.getAllQuestions().size();
		questionService.create(question);
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

		questionService.deleteByQuestionId(question.getQuestionId());
		boolean activeAfter = question.getIsActive();

		assertEquals(activeBefore, !activeAfter);
	}

	@Test
	public void testToggleQuestionStatus() {
		Question question = new Question();
		question.setQuestionId(99999);
		question.setIsActive(true);
		questionService.create(question);
		questionService.toggleQuestionStatus(question.getQuestionId());
		questionService.deleteByQuestionId(question.getQuestionId());
		assertEquals(true, question.getIsActive());
	}
}
