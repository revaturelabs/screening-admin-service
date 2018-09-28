package com.revature.caliber.services;


import com.revature.caliber.beans.Question;
import com.revature.caliber.daos.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Autowired
	private QuestionDAO questionDao;
	
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
	public Question getByQustionId(int questionId) {
		return questionDao.findById(questionId).orElse(null);
	}

	@Override
	@Transactional
	public Question updateQuestion(Question question) {
		return questionDao.save(question);
	}

	@Override
	@Transactional
	public void toggleQuestionStatus(int questionId) {
		if (questionDao.findById(questionId).isPresent()) {
			Question q = questionDao.findById(questionId).get();
			q.setIsActive(!q.getIsActive());
			questionDao.save(q);
		}

	}

	@Override
	public void deleteByBucketId(int bucketId) {
		questionDao.deleteByBucketBucketId(bucketId);
	}
}
