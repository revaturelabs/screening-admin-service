package com.revature.caliber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.caliber.beans.Category;
import com.revature.caliber.daos.CategoryDAO;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDAO cd;

	@Transactional
	@Override
	public Category create(Category category) {
		return cd.save(category);
		
	}

	@Override
	public List<Category> findAll() {
		return cd.findAll();
	}

}