package com.revature.caliber.services;


import java.util.List;

import com.revature.caliber.beans.Category;

public interface CategoryService {
	/**
	 * Retrieves all the Categories, active and non-active
	 * 
	 * @return list containing all the Categories found
	 */
	List<Category> findAll();
	
	/**
	 * Adds a new Category to the database
	 * 
	 * @param Category - Category to be added
	 * @return a Category that has been added
	 */
	Category create(Category category);
}