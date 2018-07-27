package com.revature.caliber.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Question;

/**
 * Repository that contains all methods used to manipulate Questions
 * 
 * @author Ethan Conner	  | 1805-WVU -MAY29  | Richard Orr
 * @author Adil Iqbal	  | 1805-WVU -MAY29  | Richard Orr
 */
@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
	
	/**
	 * Returns Question from given id
	 * 
	 * @author Adil Iqbal	  | 1805-WVU -MAY29  | Richard Orr
	 * 
	 * @param questionId - id of Question
	 * @return Question 
	 */
	public Question findByQuestionId(Integer questionId);
	
	
	/**
	 * Returns Bucket of given id
	 * 
	 * @author Adil Iqbal	  | 1805-WVU -MAY29  | Richard Orr
	 * 
	 * @param bucketId - id of Bucket
	 * @return Bucket of given id
	 */
	public List<Question> findByBucketId(Integer bucketId);
	
	
}