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
	 * Adds a new Category to the DB, but unlike create(), this method will
	 * commit/flush changes to DB immediately
	 * 
	 * @param Category - Category to be added
	 * @return a Category that was added
	 */
	Category saveCategory(Category category);

	/**
	 * Deletes a Category by id
	 * 
	 * @param id - id of the Category to delete
	 */
	void deleteByCategoryID(int id);
}
