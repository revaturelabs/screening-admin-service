package com.revature.caliber.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Category;
import com.revature.caliber.beans.SkillType;
import com.revature.caliber.beans.Weight;
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
	
	@Autowired
	private WeightService ws;
	
	@Override
	public List<SkillType> getSkills() {
		return skillDao.findAll();
	}

	@Override
	@Transactional
	public SkillType createSkill(SkillType s) {
		return skillDao.save(s);
	}

	@Override
	public SkillType getSkill(Integer id) {
		return skillDao.findOne(id);
	}

	@Override
	@Transactional
    public void updateSkill(SkillType s) {
        SkillType comp = skillDao.findOne(s.getSkillTypeId());
        // find any removed categories
        for (Category c : comp.getCategories()) {
            if (!s.getCategories().contains(c)) {
                // category has been removed
                // remove weight
                StringBuilder sb = new StringBuilder();
                sb.append(s.getSkillTypeId());
                sb.append(c.getCategoryId());
                long weightId = Long.parseLong(sb.toString());
                ws.deleteById(weightId);
            }
        }
        // find any added categories
        for (Category c : s.getCategories()) {
            if (!comp.getCategories().contains(c)) {
                // category added
                // add weight
                ws.create(new Weight(0, 0, s.getSkillTypeId(), c.getCategoryId()));
            }
        }
        skillDao.saveOnly(s.getSkillTypeId(), s.getTitle(), s.isActive());
    }

	@Override
	@Transactional
	public void deleteSkill(Integer id) {
		skillDao.delete(id.intValue());
	}

	@Override
	public List<SkillType> getActiveSkills(boolean b) {
		return skillDao.findAllByIsActive(b);
	}


}
