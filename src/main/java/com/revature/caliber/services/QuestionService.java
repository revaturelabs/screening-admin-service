package com.revature.caliber.services;

import java.util.List;
import io.swagger.annotations.ApiModel;

import com.revature.caliber.beans.Question;

/**
 * Interface that contains associated with the Question POJO
 * 
 * @author Alexia Doramus | 1803-USF-MAR26 | Wezley Singleton
 * @author Joanel Vasquez | 1803-USF-MAR26 | Wezley Singleton
 * @author Isaac Pawling  | 1805-WVU | Richard Orr
 * @author Ethan Conner	  | 1805-WVU -MAY29  | Richard Orr
 * @author Adil Iqbal	  | 1805-WVU -MAY29  | Richard Orr
 */

@ApiModel(value="QuestionService", description="Provides an interface for the Service layer")
public interface QuestionService {
	
	
	/**
	 * Add a question to the database
	 * 
	 * @param transient question
	 * @return Question
	 */
	public Question create(Question question);
	
	/**
	 * Gets all questions
	 * 
	 * @return Question List 
	 */
	public List<Question> getQuestions();
	
	/**
	 * Gets questions based on bucketId
	 * @param bucketId of bucket
	 * @return List of questions in the specified bucket
	 */
	public List<Question> getQuestionsByBucket(Integer bucketId);
	
	/**
	 * Delete question by id
	 * @param questionId Id of question
	 * No return
	 */
	public void deleteByQuestionId(Integer questionId);
	
	/**
	 * update question
	 * @param question - a Question object
	 * @return updated Question object
	 */
	public Question updateQuestion(Question question);
	
	/**
	 * change the status of the question
	 * @param isActive - boolean determining if question is active
	 * @param questionId - Id of question
	 * No return
	 */
	public void toggleQuestionStatus(Boolean isActive, Integer questionId);

}
