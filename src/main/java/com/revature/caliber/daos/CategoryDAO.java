package com.revature.caliber.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer> {

	public List<Category> findAll();
		
}
