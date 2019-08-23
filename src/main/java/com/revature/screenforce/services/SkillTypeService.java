package com.revature.screenforce.services;

import io.swagger.annotations.ApiModel;

import java.util.List;

import com.revature.screenforce.beans.SkillType;

/**
 * Defines available methods for the SkillType service interface
 * 
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */
@ApiModel(value = "SkillTypeService", description = "Provides interface for SkillType service layer")
public interface SkillTypeService {

	/**
	 * Method that returns all SkillTypes
	 * @return list of skillType objects
	 */
	public List<SkillType> getAllSkillTypes();
	
	/**
	 * Method that returns all active SkillTypes
	 * @return list of SkillType objects
	 */
	public List<SkillType> getActiveSkillTypes(boolean b);
	
	/**
	 * Method that returns a specific SkillType
	 * @param id the primary key of the SkillType
	 * @return an individual skillType
	 */
	public SkillType getSkillType(int id);
	
	/**
	 * Creates a new skillType
	 * @param s transient skillType
	 * @return detached skillType
	 */
	public SkillType createSkillType(SkillType s);
	
	/**
	 * Updates a skill's title
	 * @param s existing skill object w/ updated title
	 */
	public void updateSkillType(SkillType s);
	
	/**
	 * Removes skill with specified Id
	 * @param id primary key of skill to review
	 */
	public void deleteSkillType(int id);

	
	/**
	 * Gets the skill by its id
	 * @param skillTypeId primary key of skill to get
	 */
	public SkillType getSkillTypeById(int skillTypeId);
	
	/**
	 * Check if id exist
	 * @param id ID of skill type
	 */
	public boolean existsById(int id);
}
