package com.revature.caliber.daos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Question;

/**
 * Repository that contains methods used to fetch and manipulate Questions
 * 
 * @author Alexia Doramus | 1803-USF-MAR26 | Wezley Singleton
 * @author Joanel Vasquez | 1803-USF-MAR26 | Wezley Singleton
 * @author Ethan Conner	  | 1805-WVU -MAY29  | Richard Orr
 * @author Adil Iqbal	  | 1805-WVU -MAY29  | Richard Orr
 * @author Isaac Pawling  | 1805-WVU		 | Richard Orr
 */
@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
	
	/**
	 * Returns Question from given id
	 * 
	 * @param questionId - id of Question
	 * @return Question 
	 */
	public Question findByQuestionId(Integer questionId);	
	
	/**
	 * Returns Questions in a particular bucket
	 * 
	 * @param bucketId - id of Bucket
	 * @return list of questions in the specified bucket
	 */
	public List<Question> findByBucketId(Integer bucketId);

	public void deleteByBucketId(int intValue);
}
