package com.revature.caliber.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Weight;
import com.revature.caliber.daos.WeightDAO;

/**
 * Provides implementation for the weight service layer
 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
 *
 */
@Service
public class WeightServiceImpl implements WeightService {

	@Autowired
	private WeightDAO wd;
	
	@Override
	public List<Weight> getWeights() {
		return wd.findAll();
	}


	@Override
	public Weight getWeightBySkillTypeAndCategory(int skillTypeId, int categoryId) {
		StringBuilder sb = new StringBuilder();
		sb.append(skillTypeId);
		sb.append(categoryId);
		long weightId = Long.parseLong(sb.toString());
		return wd.findOne(weightId);
	}

	@Override
	@Transactional
	public void update(Weight weight) {
		wd.save(weight);

	}

	@Override
	@Transactional
	public Weight create(Weight weight) {
		StringBuilder sb = new StringBuilder();
		sb.append(weight.getSkillTypeId());
		sb.append(weight.getCategoryId());
		long weightId = Long.parseLong(sb.toString().trim());
		weight.setWeightId(weightId);
		return wd.save(weight);
	}

	@Override
	@Transactional
	public void deleteById(long weightId) {
		wd.delete(weightId);
	}
}
