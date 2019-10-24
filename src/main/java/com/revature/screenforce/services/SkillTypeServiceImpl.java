package com.revature.screenforce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.SkillType;
import com.revature.screenforce.repositories.SkillTypeRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementation for the SkillType service interface
 * 
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */
@Service
public class SkillTypeServiceImpl implements SkillTypeService {
	private SkillTypeRepository skillTypeRepository;
	/** Weight service */
	private WeightService weightService;

	/**
	 * Instantiates a new skill type service
	 *
	 * @param skillTypeRepository Skill type repository
	 * @param weightService Weight service
	 */
	@Autowired
	public SkillTypeServiceImpl(SkillTypeRepository skillTypeRepository,
								WeightService weightService) {
		this.skillTypeRepository = skillTypeRepository;
		this.weightService = weightService;
	}

	/**
	 * Method that returns all SkillTypes
	 * @return list of skillType objects
	 */
	@Override
	public List<SkillType> getAllSkillTypes() {
		return skillTypeRepository.findAll();
	}

	/**
	 * Creates a new skillType
	 * @param s transient skillType
	 * @return detached skillType
	 */
	@Override
	@Transactional
	public SkillType createSkillType(SkillType s) {
		return skillTypeRepository.save(s);
	}

	/**
	 * Method that returns a specific SkillType
	 * @param id the primary key of the SkillType
	 * @return an individual skillType
	 */
	@Override
	public SkillType getSkillType(int id) {
		return skillTypeRepository.findById(id).orElse(null);
	}

	/**
	 * Updates a skill's title
	 * @param s existing skill object w/ updated title
	 */
	@Override
	@Transactional
    public void updateSkillType(SkillType s) {
        skillTypeRepository.saveOnly(s.getSkillTypeId(), s.getTitle(), s.isActive());
    }

	/**
	 * Removes skill with specified Id
	 * @param id primary key of skill to review
	 */
	@Override
	@Transactional
	public void deleteSkillType(int id) {
		weightService.deleteAllBySkillTypeSkillTypeId(id);
		skillTypeRepository.deleteById(id);
	}

	/**
	 * Method that returns all active SkillTypes
	 * @return list of SkillType objects
	 */
	@Override
	public List<SkillType> getActiveSkillTypes(boolean b) {
		return skillTypeRepository.findAllByIsActive(b);
	}

	/**
	 * Gets the skill by its id
	 * @param skillTypeId primary key of skill to get
	 */
	@Override
	public SkillType getSkillTypeById(int skillTypeId) {
		return skillTypeRepository.findById(skillTypeId).orElse(null);
	}

	/**
	 * Check if id exist
	 * @param id ID of skill type
	 */
	@Override
	public boolean existsById(int id) {
		return skillTypeRepository.existsById(id);
	}
}
