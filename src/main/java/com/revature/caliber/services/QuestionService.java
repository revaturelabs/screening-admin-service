package com.revature.caliber.services;

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
	
}

