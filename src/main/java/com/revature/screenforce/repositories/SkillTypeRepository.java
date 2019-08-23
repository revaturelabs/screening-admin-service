package com.revature.screenforce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.screenforce.beans.SkillType;

/**
 * DAO Repository for the SkillType utilizing
 * JpaRepository & CrudRepository interface methods
 * 
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */
@Repository
public interface SkillTypeRepository extends JpaRepository<SkillType, Integer> {
	
	/**
	 * Gets all active or inactive SkillType objects
	 * 
	 * @param b the boolean determining active status
	 * @return list of SkillType objects
	 */
	public List<SkillType> findAllByIsActive(boolean b);

	/**
	 * Updates a skill type by ID
	 *
	 * @param id ID of skill type
	 * @param title Name of skill type
	 * @param b Active state of skill type
	 */
    @Modifying
    @Query("update SkillType s set s.title = ?2, s.isActive = ?3 where s.skillTypeId = ?1")
    public void saveOnly(int id, String title, Boolean b);
}
