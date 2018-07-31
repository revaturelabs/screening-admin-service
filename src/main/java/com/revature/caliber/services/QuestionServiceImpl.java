package com.revature.caliber.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.caliber.beans.Question;
import com.revature.caliber.daos.QuestionDAO;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionDAO questionDao;
	
	@Transactional
	@Override
	public Question create(Question question) {
		return questionDao.save(question);	
	}
	
	public List<Question> getQuestionsByBucket(Integer bucketId) {
		return questionDao.findByBucketId(bucketId);
	}
	@Transactional
	@Override
	public void deleteByQuestionId(Integer questionId) {
		questionDao.delete(questionId);
	}
	@Override
	public Question updateQuestion(Question question) {
		return questionDao.save(question);
	}
	@Override
	@Transactional
	public void toggleQuestionStatus(Boolean isActive, Integer questionId) {
		Question q = questionDao.findOne(questionId);
		q.setIsActive(isActive);
		questionDao.save(q);
	}

}