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
	private WeightService weightService;

	@Autowired
	public SkillTypeServiceImpl(SkillTypeRepository skillTypeRepository, WeightService weightService) {
		this.skillTypeRepository = skillTypeRepository;
		this.weightService = weightService;
	}
	
	@Override
	public List<SkillType> getAllSkillTypes() {
		return skillTypeRepository.findAll();
	}

	@Override
	@Transactional
	public SkillType createSkillType(SkillType s) {
		return skillTypeRepository.save(s);
	}

	@Override
	public SkillType getSkillType(int id) {
		return skillTypeRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
    public void updateSkillType(SkillType s) {
        skillTypeRepository.saveOnly(s.getSkillTypeId(), s.getTitle(), s.isActive());
    }

	@Override
	@Transactional
	public void deleteSkillType(int id) {
		weightService.deleteAllBySkillTypeSkillTypeId(id);
		skillTypeRepository.deleteById(id);
	}

	@Override
	public List<SkillType> getActiveSkillTypes(boolean b) {
		return skillTypeRepository.findAllByIsActive(b);
	}

	@Override
	public SkillType getSkillTypeById(int skillTypeId) {
		return skillTypeRepository.findById(skillTypeId).orElse(null);
	}

	@Override
	public boolean existsById(int id) {
		return skillTypeRepository.existsById(id);
	}
}
