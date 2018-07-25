package com.revature.caliber.services;

import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.revature.caliber.beans.Question;

/**
 * Interface that contains associated with the Question POJO
 * 
 * @author Alexia Doramus | 1803-USF-MAR26 | Wezley Singleton
 * @author Joanel Vasquez | 1803-USF-MAR26 | Wezley Singleton
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */

@ApiModel(value="QuestionService", description="Provides an interface for the Service layer")
public interface QuestionService {
	
	/**
	 * Gets questions based on bucketId
	 * 
	 * @param bucketId of bucket
	 * @return Question List
	 */
	@ApiModelProperty(value="All questions in a bucket")
	public List<Question> getQuestionsByBucket(Integer bucketId);

	/**
	 * Add a new question to the database
	 * 
	 * @param transient question
	 * @return detatched question
	 */
	@ApiModelProperty(value = "Inserts a new question")
	public Question create(Question question);
	
}
