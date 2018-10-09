package com.revature.screenforce.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.screenforce.beans.Question;

import java.util.List;

/**
 * Repository that contains methods used to fetch and manipulate Questions
 * 
 * @author Alexia Doramus | 1803-USF-MAR26 | Wezley Singleton
 * @author Joanel Vasquez | 1803-USF-MAR26 | Wezley Singleton
 * @author Ethan Conner | 1805-WVU -MAY29 | Richard Orr
 * @author Adil Iqbal | 1805-WVU -MAY29 | Richard Orr
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

	/**
	 * Returns Questions in a particular bucket
	 * 
	 * @param bucketId
	 *            - id of Bucket
	 * @return list of questions in the specified bucket
	 */
	List<Question> findAllByBucketBucketId(int bucketId);

	/**
	 * Delete all questions with matching bucket Id
	 *
	 * @param bucketId ID of bucket to filter by
	 */
	void deleteByBucketBucketId(int bucketId);
}
