package com.revature.caliber.services;

import com.revature.caliber.beans.Category;

public interface CategoryService {
	/**
	 * Adds a new Category to the database
	 * 
	 * @param Category - Category to be added
	 * @return a Category that has been added
	 */
	Category create(Category category);

}