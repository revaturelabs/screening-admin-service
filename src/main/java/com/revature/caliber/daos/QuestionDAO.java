package com.revature.caliber.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Question;

/**
 * Repository that contains all methods used to manipulate Questions
 * 
 * @author Alexia Doramus | 1803-USF-MAR26 | Wezley Singleton
 * @author Joanel Vasquez | 1803-USF-MAR26 | Wezley Singleton
 * @author Ethan Conner	  | 1805-WV -AUG3  | Richard Orr
 */
@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
	
}