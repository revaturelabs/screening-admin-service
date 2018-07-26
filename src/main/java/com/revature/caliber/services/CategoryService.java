package com.revature.caliber.services;

import java.util.List;

import com.revature.caliber.beans.Category;

public interface CategoryService {
	/**
	 * Adds a new Category to the database
	 * 
	 * @param Category - Category to be added
	 * @return a Category that has been added
	 */

	Category create(Category category);

	/**
	 * Retrieves all the Categories, active and non-active
	 * 
	 * @return list containing all the Categories found
	 */
	List<Category> findAll();
	
	/**
	 * Retrieves all the active Categories
	 * 
	 * @return list containing all the Categories found
	 */
	List<Category> findAllActive();

	/**
	 * Retrieves a Category by id
	 * 
	 * @param id - id of Category being retrieved
	 * @return a Category
	 */
	Category findByCategoryID(int id);

	/**
	 * Deletes a Category by id
	 * 
	 * @param id - id of the Category to delete
	 */
	public void deleteCategory(Integer categoryId);
	
	/**
	 * Updates a Category
	 * 
	 * @return an updated category
	 */
	public void updateCategory(Category category);

}