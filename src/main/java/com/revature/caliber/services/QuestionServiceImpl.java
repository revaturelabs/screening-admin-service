package com.revature.caliber.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.caliber.beans.Question;
import com.revature.caliber.daos.QuestionDAO;

@Service
public class QuestionServiceImpl implements QuestionService {

	
	@Autowired
	private QuestionDAO questionDao;
	
	@Override
	public List<Question> getQuestionsByBucket(int bucketId) {
		return questionDao.findByBucketId(bucketId);
	}
	
	@Transactional
	@Override
	public Question create(Question question) {
		return questionDao.save(question);
		
	}

}