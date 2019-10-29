package com.revature.screenforce.services;

import java.util.List;

import com.revature.screenforce.beans.Question;

import io.swagger.annotations.ApiModel;

/**
 * Interface that contains associated with the Question POJO
 * 
 * @author Alexia Doramus | 1803-USF-MAR26 | Wezley Singleton
 * @author Joanel Vasquez | 1803-USF-MAR26 | Wezley Singleton
 * @author Isaac Pawling  | 1805-WVU | Richard Orr
 * @author Ethan Conner	  | 1805-WVU -MAY29  | Richard Orr
 * @author Adil Iqbal	  | 1805-WVU -MAY29  | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */

@ApiModel(value="QuestionService", description="Provides an interface for the Service layer")
public interface QuestionService {
	
	
	/**
	 * Add a question to the database
	 * 
	 * @param question transient question to be persisted
	 * @return Question
	 */
	Question create(Question question);
	
	/**
	 * Gets all questions
	 *
	 * @return Question List
	 */
	List<Question> getAllQuestions();
	
	/**
	 * Gets questions based on categoryId
	 * @param categoryId of category
	 * @return List of questions in the specified category
	 */
	List<Question> getQuestionsByCategory(int categoryId);
	
	/**
	 * Delete question by id
	 * @param questionId Id of question
	 * No return
	 */
	void deleteByQuestionId(int questionId);

	/**
	 * Get question by questionId
	 * @param questionId Id of the question to filter by
	 * @return Question object with matching questionId
	 */
	Question getByQuestionId(int questionId);
	
	/**
	 * update question
	 * @param question - a Question object
	 * @return updated Question object
	 */
	Question updateQuestion(Question question);

    /**
     * Delete all questions associated with a specific category
     * @param categoryId to filter by
     */
	void deleteByCategoryId(int categoryId);
	
	/**
	 * Check if id exist
	 * @param questionId ID of question
	 */
	public boolean existsById(int questionId);
}
