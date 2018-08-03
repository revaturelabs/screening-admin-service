package com.revature.caliber.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Weight;

/**
 * 
 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
 * Data Access Obj for Weight
 *
 */
@Repository
public interface WeightDAO extends JpaRepository<Weight, Long>{

	void deleteByCategoryId(Integer categoryId);

	void deleteBySkillTypeId(int id);

}