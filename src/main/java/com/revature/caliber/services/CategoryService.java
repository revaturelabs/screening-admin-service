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
}