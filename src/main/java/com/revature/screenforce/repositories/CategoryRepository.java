package com.revature.screenforce.repositories;

import org.springframework.stereotype.Repository;

import com.revature.screenforce.beans.Category;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * DAO Repository for Category utilizing
 * JpaRepository & CrudRepository interface methods
 *  
 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}

