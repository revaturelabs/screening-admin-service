package com.revature.screenforce.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.screenforce.beans.Question;
import com.revature.screenforce.daos.QuestionDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the QuestionService
 * Calls the appropriate QuestionDAO method
 * 
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 * @author Adil Iqbal	 | 1805-WVU | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */

@Service
public class QuestionServiceImpl implements QuestionService {
	
	//Richard: Swapped field injection for constructor injection and cleaned up code with Cody
	
	public QuestionDAO questionDao;
	@Autowired
	public QuestionServiceImpl(QuestionDAO questionDao) {
		this.questionDao = questionDao;
	}
	
	@Transactional
	@Override
	public Question create(Question question) {
		return questionDao.save(question);	
	}

	@Override
	public List<Question> getAllQuestions() {
		return questionDao.findAll();
	}

	@Override
	public List<Question> getQuestionsByBucket(int bucketId) {
		return questionDao.findAllByBucketBucketId(bucketId);
	}

	@Transactional
	@Override
	public void deleteByQuestionId(int questionId) {
		questionDao.deleteById(questionId);
	}

	@Override
	public Question getByQuestionId(int questionId) {
		return questionDao.findById(questionId).orElse(null);
	}

	@Override
	@Transactional
	public Question updateQuestion(Question question) {
		return questionDao.save(question);
	}

	@Override
	@Transactional
	public void deleteByBucketId(int bucketId) {
		List<Question> q = new ArrayList<Question>();
		q.addAll(getQuestionsByBucket(bucketId));
		
		for (Question question : q) {
			deleteByQuestionId(question.getQuestionId());
		}
	}

	@Override
	public boolean existsById(int id) {
		return questionDao.existsById(id);
	}
}
