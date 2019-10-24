package com.revature.screenforce.services;

import com.revature.screenforce.repositories.BucketRepository;
import com.revature.screenforce.repositories.QuestionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.beans.Question;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Question Tests using JUnit
 *
 * @author Omar Guzman | 1807-QC | Emily Higgins
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class QuestionServiceImplTest {
	@Mock QuestionRepository questionRepository;
	@Mock BucketRepository bucketRepository;
	@Mock CategoryServiceImpl bucketService;
	@InjectMocks QuestionServiceImpl questionService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreate() {
		// Mock DAO save()
		when(questionRepository.save(any(Question.class))).thenReturn(new Question());
		assertNotNull(questionService.create(new Question()));
	}

	@Test
	public void testGetAllQuestions() {
		// Mock DAO findAll()
		List<Question> questions = new ArrayList<>();
		when(questionRepository.findAll()).thenReturn(questions);

		int nQuestions = questions.size();
		assertEquals(nQuestions, questionService.getAllQuestions().size());
	}

	@Test
	public void testGetQuestionsByBucket() {
		// Mock DAO save() question
		when(questionRepository.save(any(Question.class))).thenReturn(new Question());
		List<Question> questions = new ArrayList<>();
		questions.add(questionService.create(new Question()));

		// Mock DAO findAllByBucketId()
		when(questionRepository.findAllByBucketBucketId(any(Integer.class)))
				.thenReturn(questions);

		assertEquals(questions.size(),
				questionService.getQuestionsByBucket(1).size());
	}

	@Test
	public void testDeleteByQuestionId() {
		// Mock DAO save() question
		List<Question> questions = new ArrayList<>();
		Question q1 = new Question(); q1.setQuestionId(1);
		when(questionRepository.save(any(Question.class))).thenReturn(q1);
		questions.add(questionService.create(q1));

		// Mock DAO deleteById() q1
		questionService.deleteByQuestionId(q1.getQuestionId());
		questions.remove(q1);

		when(questionRepository.findAll()).thenReturn(questions);
		assertEquals(questions.size(), questionService.getAllQuestions().size());
	}

	@Test
	public void testUpdateQuestion() {
		// Mock DAO saving question
		Question q1 = new Question();
		q1.setQuestionId(1);
		q1.setIsActive(false);
		when(questionRepository.save(any(Question.class))).thenReturn(q1);

		q1.setIsActive(true);
		assertEquals(q1.getIsActive(),
				questionService.updateQuestion(q1).getIsActive());
	}

	@Test
	public void testDeleteByBucketId() {
		// Mock DAO findAllByBucketBucketId()
		Bucket bucket = new Bucket();
		bucket.setBucketId(406);
		List<Question> questions = new ArrayList<>();
		Question q = new Question();
		q.setBucket(bucket);
		questions.add(q);
		when(questionRepository.findAllByBucketBucketId(any(Integer.class)))
				.thenReturn(questions);

		// Mock DAO deleteByBucketBucketId()
		questionRepository.deleteByBucketBucketId(bucket.getBucketId());
		questions.remove(q);

		assertEquals(questions.size(),
				questionService.getQuestionsByBucket(bucket.getBucketId()).size());
	}
	
	@Test
	public void testExistById() {
		when(questionRepository.existsById(any(Integer.class))).thenReturn(true);
		assertTrue(questionService.existsById(384));
	}
	
	@Test
	public void testExistByIdFail() {
		when(questionRepository.existsById(any(Integer.class))).thenReturn(false);
		assertFalse(questionService.existsById(-1));
	}
}
