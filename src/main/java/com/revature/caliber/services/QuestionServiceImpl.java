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
	
	public List<Question> getAllQuestions() {
		return questionDao.findAll();
	}
	
	public List<Question> getQuestionsByBucket(int bucketId) {
		return questionDao.findByBucketId(bucketId);
	}
	@Transactional
	@Override
	public void deleteByQuestionId(int questionId) {
		questionDao.deleteById(questionId);
	}
	@Override
	@Transactional
	public Question updateQuestion(Question question) {
		return questionDao.save(question);
	}
	@Override
	@Transactional
	public void toggleQuestionStatus(boolean isActive, int questionId) {
		if (questionDao.findById(questionId).isPresent()) {
			Question q = questionDao.findById(questionId).get();
			q.setIsActive(isActive);
			questionDao.save(q);
		}

	}

}
