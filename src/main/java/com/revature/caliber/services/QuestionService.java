package com.revature.caliber.services;

import java.util.List;

import com.revature.caliber.beans.Question;

/**
 * Interface that contains methods to be implemented for question status toggling and to grab
 * 
 * @author Alexia Doramus | 1803-USF-MAR26 | Wezley Singleton
 * @author Joanel Vasquez | 1803-USF-MAR26 | Wezley Singleton
 *
 */

public interface QuestionService {
	
	/**
	 * Gets questions based on bucketId
	 * 
	 * @param bucketId of bucket
	 * @return Question List
	 */
	public List<Question> getQuestionsByBucket(Integer bucketId);
}
