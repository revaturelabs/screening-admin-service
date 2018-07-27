package com.revature.caliber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.SkillType;
import com.revature.caliber.daos.SkillTypeDAO;

/**
 * Implementation for the SkillType service interface
 * 
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */
@Service
public class SkillTypeServiceImpl implements SkillTypeService {

	@Autowired
	private SkillTypeDAO skillDao;
	
	@Override
	public List<SkillType> getSkills() {
		return skillDao.findAll();
	}

	@Override
	public SkillType createSkill(SkillType s) {
		return skillDao.save(s);
	}

	@Override
	public SkillType getSkill(Integer id) {
		return skillDao.findOne(id);
	}

	@Override
	public void updateSkill(SkillType s) {
		skillDao.save(s);
	}

	@Override
	public void deleteSkill(Integer id) {
		skillDao.delete(id);
	}


}
