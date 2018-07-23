package com.revature.caliber.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Category;

@Repository
public interface CategoryDAO  extends JpaRepository<Category, Integer>{
	
	
    public Category findByCategoryId(int categoryId);
    
    @Query("update Category c set c.isActive = ?1, c.title = ?2 where c.categoryId = ?3")
    public Category update(boolean isActive, String title, int categoryId);
    
    
    public Category save(Category category);
    public void delete(Category category);
    public List<Category> findByIsActive(boolean isActive);

}