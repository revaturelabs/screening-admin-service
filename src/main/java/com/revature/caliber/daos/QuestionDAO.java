package com.revature.caliber.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Question;

/**
 * Repository that contains all methods used to manipulate Questions
 * 
 * @author Alexia Doramus | 1803-USF-MAR26 | Wezley Singleton
 * @author Joanel Vasquez | 1803-USF-MAR26 | Wezley Singleton
 */
@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
	
	/**
	 * Returns Question from given id
	 * 
	 * @author Alexia Doramus | 1803-USF-MAR26 | Wezley Singleton
	 * @author Joanel Vasquez | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param questionId - id of Question
	 * @return Question 
	 * 
	 * ITP - I think the .getOne() JPA repository method takes care of this for us
	 */
	public Question findByQuestionId(Integer questionId);
	
	/**
	 * Toggles Question status to (in)active based on given information
	 * 
	 * @author Alexia Doramus | 1803-USF-MAR26 | Wezley Singleton
	 * @author Joanel Vasquez | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param isActive - sets Question to active if true, inactive otherwise
	 * @param questionId - id of Question to be toggled
	 */
	@Modifying(clearAutomatically = true)
	@Query("update Question q set q.isActive = ?1 where q.questionId = ?2")
	public void toggleQuestionStatusById(Boolean isActive, Integer questionId);
	
	/**
	 * Returns Bucket of given id
	 * 
	 * @author Alexia Doramus | 1803-USF-MAR26 | Wezley Singleton
	 * @author Joanel Vasquez | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param bucketId - id of Bucket
	 * @return Bucket of given id
	 */
	public List<Question> findByBucketId(Integer bucketId);
	
	/**
	 * Gets those Questions with the specified questionIds belonging to the specified Buckets
	 * 
	 * @author Alexia Doramus | 1803-USF-MAR26 | Wezley Singleton
	 * @author Joanel Vasquez | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param questionIds - list of valid questionIds, preferably containing one of several Tags
	 * @param bucketIds - list of valid bucketIds, preferably within the same SkillType
	 * @return list of Questions
	 */
	@Query("SELECT q FROM Question q WHERE q.questionId IN (?1) AND q.bucketId IN (?2)")
	public List<Question> getSpecificQuestionsByBucketId(List<Integer> questionIds, List<Integer> bucketIds);	

}