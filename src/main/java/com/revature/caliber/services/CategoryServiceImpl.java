package com.revature.caliber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.caliber.beans.Category;
import com.revature.caliber.daos.CategoryDAO;
import com.revature.caliber.daos.WeightDAO;

/**
 * Implementation for the Category Service layer
 * @author Zia Mohiuddin | 1805-WVU | Richard Orr
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDAO cd;
	
	@Autowired
	WeightDAO wd;

	@Transactional
	@Override
	public Category create(Category category) {
		return cd.save(category);
		
	}

	@Override
	public List<Category> findAll() {
		return this.cd.findAll();
	}


	@Override
	public List<Category> findAllActive() {		
	return this.cd.findAllByIsActive(true);
	}

	@Override
	public Category findByCategoryID(int id) {
		return this.cd.findOne(id);
	}

	@Transactional
	@Override
	public void deleteCategory(Integer categoryId) {
		wd.deleteByCategoryId(categoryId);
		cd.delete(categoryId);
	}
	
	@Transactional
	@Override
	public void updateCategory(Category category) {
		cd.save(category);
	}
}
