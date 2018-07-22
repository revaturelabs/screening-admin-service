package com.revature.caliber.services;

import java.util.List;

import com.revature.caliber.beans.Question;

public interface QuestionService {
	
	/**
	 * Gets questions based on bucketId
	 * 
	 * @param bucketId of bucket
	 * @return Question List
	 */
	public List<Question> getQuestionsByBucket(int bucketId);

	public Question create(Question question);
}