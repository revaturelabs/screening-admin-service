package com.revature.caliber.daos;

import com.revature.caliber.beans.SkillType;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO Repository for the SkillType utilizing
 * JpaRepository & CrudRepository interface methods
 * 
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */
@Repository
public interface SkillTypeDAO extends JpaRepository<SkillType, Integer> {
	
}
