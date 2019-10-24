package com.revature.screenforce.services;

import io.swagger.annotations.ApiModel;

import java.util.List;

import com.revature.screenforce.beans.Bucket;


/**
 * Interface for our Bucket service layer
 *  
 * @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
 * @author Theo Thompson | 1805-WVU-MAY29 | Richard Orr
 * 
 */
@ApiModel(value = "CategoryService", description = "Provides interface for the Category service layer")
public interface CategoryService {

	/**
	 * creates a new category in the DB
	 * @param category - a new category
	 * @return Category obj w/ updated id
	 */
	public Category createCategory(Category category);

	/**
	 * Fetches all categories 
	 * @return list of categories
	 */
	public List<Category> getAllCategory();
	
	/**
	 * Updates category information
	 * @param category - category to update
	 */
	public void updateCategory(Category category);
	
	/**
	 * Gets a category by its Id
	 * @param categoryId Id of category to filter by
	 * @return category or null if id is not found
	 */
	public Category getCategoryById(int categoryId);
	
	/**
	 * Removes a Category with the specified Id
	 * @param categoryId - id of the category to be deleted
	 * No return
	 */
	public void deleteCategory(int categoryId);

	/**
	 * Check if id exist
	 * @param categoryId - id of the category
	 */
	public boolean existsById(int categoryId);
}
