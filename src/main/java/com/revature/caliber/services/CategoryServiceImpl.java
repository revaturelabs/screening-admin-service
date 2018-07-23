package com.revature.caliber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.caliber.beans.Category;
import com.revature.caliber.daos.CategoryDAO;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDAO cd;

	@Override
	public List<Category> findAll() {
		return cd.findAll();
	}


}