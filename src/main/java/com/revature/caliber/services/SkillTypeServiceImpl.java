package com.revature.caliber.services;

import java.util.List;

import javax.transaction.Transactional;

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
	private SkillTypeDAO skillTypeDao;
	
	@Autowired
	private WeightService ws;
	
	@Override
	public List<SkillType> getAllSkillTypes() {
		return skillTypeDao.findAll();
	}

	@Override
	@Transactional
	public SkillType createSkillType(SkillType s) {
		return skillTypeDao.save(s);
	}

	@Override
	public SkillType getSkillType(Integer id) {
		return skillTypeDao.findOne(id);
	}

	@Override
	@Transactional
    public void updateSkillType(SkillType s) {
        skillTypeDao.saveOnly(s.getSkillTypeId(), s.getTitle(), s.isActive());
    }

	@Override
	@Transactional
	public void deleteSkillType(Integer id) {
		skillTypeDao.delete(id.intValue());
	}

	@Override
	public List<SkillType> getActiveSkillTypes(boolean b) {
		return skillTypeDao.findAllByIsActive(b);
	}


}
