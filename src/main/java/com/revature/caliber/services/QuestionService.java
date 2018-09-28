package com.revature.caliber.services;

import com.revature.caliber.beans.Question;
import io.swagger.annotations.ApiModel;

import java.util.List;

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
	 * Gets questions based on bucketId
	 * @param bucketId of bucket
	 * @return List of questions in the specified bucket
	 */
	List<Question> getQuestionsByBucket(int bucketId);
	
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
	Question getByQustionId(int questionId);
	
	/**
	 * update question
	 * @param question - a Question object
	 * @return updated Question object
	 */
	Question updateQuestion(Question question);
	
	/**
	 * Toggle the status of the question
	 * @param questionId - Id of question
	 * No returns
	 */
	void toggleQuestionStatus(int questionId);

    /**
     * Delete all questions associated with a specific bucket
     * @param bucketId Id of bucket to filter by
     */
	void deleteByBucketId(int bucketId);

}
