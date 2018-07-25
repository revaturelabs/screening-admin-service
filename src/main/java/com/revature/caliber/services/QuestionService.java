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
	 * @author Ethan Conner	  | 1805-WV -AUG3  | Richard Orr
	 * Add a question to the database
	 * 
	 * @param transient question
	 * @return Question
	 */
	public Question create(Question question);
	
	/**
	 * Gets questions based on bucketId
	 * 
	 * @param bucketId of bucket
	 * @return Question List
	 */
	public List<Question> getQuestionsByBucket(Integer bucketId);
	
	public void deleteByQuestionId(Integer questionId);
	
	public Question updateQuestion(Question question);
	
	public void toggleQuestionStatus(Boolean isActive, Integer questionId);
}

