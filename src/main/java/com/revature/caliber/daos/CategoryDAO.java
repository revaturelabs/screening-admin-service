package com.revature.caliber.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer> {
	
  //  @Query("select * from Category where Category_id = :category_id")
//	public Category findByCatergoryID(int id);
//	@Query("insert into Category (category_id, category_title, is_active) values (?,?,?)")
//	public Category create(Category category);
	
	//@Query("select * from Category")
	//@Query("select c from Category c where c.Category_id = ?1")
	//@Query("select c from Category c where c.Category_id IN (?1)")
  // @Query("select c from Category c where c.Category_id = :Category_id")
	public List<Category> findAll();
	
//	public Category saveCategory(Category category);
//	public void deleteByCategoryID(int id);
//	public List<Category> findAllActive();
	
}
