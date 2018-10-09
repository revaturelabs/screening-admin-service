package com.revature.screenforce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.Question;
import com.revature.screenforce.beans.SkillType;
import com.revature.screenforce.daos.SkillTypeDAO;

import javax.transaction.Transactional;
import java.util.List;

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
	public SkillType getSkillType(int id) {
		return skillTypeDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
    public void updateSkillType(SkillType s) {
        skillTypeDao.saveOnly(s.getSkillTypeId(), s.getTitle(), s.isActive());
    }

	@Override
	@Transactional
	public void deleteSkillType(int id) {
		ws.deleteAllBySkillTypeSkillTypeId(id);
		skillTypeDao.deleteById(id);
	}

	@Override
	public List<SkillType> getActiveSkillTypes(boolean b) {
		return skillTypeDao.findAllByIsActive(b);
	}

	@Override
	public SkillType getSkillTypeById(int skillTypeId) {
		return skillTypeDao.findById(skillTypeId).orElse(null);
	}
}
