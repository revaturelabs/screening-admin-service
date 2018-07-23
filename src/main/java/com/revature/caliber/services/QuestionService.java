package com.revature.caliber.services;

import com.revature.caliber.beans.Question;

public interface QuestionService {

	/**
	 * @author Ethan Conner	  | 1805-WV -AUG3  | Richard Orr
	 * Add a question to the database
	 * 
	 * @param transient question
	 * @return Question
	 */
	public Question create(Question question);
}