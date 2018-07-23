package com.revature.caliber.services;

import java.util.List;

import com.revature.caliber.beans.Question;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Interface that contains methods to be implemented for question status toggling and to grab
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
}
