package com.revature.caliber.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Category;
/**
 * 
 *@author Ethan Conner	| 1805-WVU-AUG3 | Richard Orr
 *@author Zia Mohiuddin	| 1805-WVU-AUG3	| Richard Orr
 * 
 * This is a Repository for the Category POJO that communicates
 * with a database to persist and retrieve category objects
 *
 */
@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer> {

	public List<Category> findAll();
		
}
