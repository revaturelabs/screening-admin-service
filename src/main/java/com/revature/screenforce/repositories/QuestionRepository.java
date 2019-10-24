package com.revature.screenforce.repositories;

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
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	/**
	 * Returns Questions in a particular category
	 * 
	 * @param categoryId
	 *            - id of category
	 * @return list of questions in the specified category
	 */
	List<Question> findAllByCategoryCategoryId(int categoryId);

	/**
	 * Delete all questions with matching category Id
	 *
	 * @param categoryId ID of category to filter by
	 */
	void deleteByCategoryCategoryId(int categoryId);
}
