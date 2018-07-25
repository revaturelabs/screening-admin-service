package com.revature.caliber.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Weight;
import com.revature.caliber.daos.WeightDAO;

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
	public void update(Weight weight) {
		wd.save(weight);

	}

	@Override
	public Weight create(Weight weight) {
		StringBuilder sb = new StringBuilder();
		sb.append(weight.getSkillTypeId());
		sb.append(weight.getCategoryId());
		long weightId = Long.parseLong(sb.toString().trim());
		weight.setWeightId(weightId);
		return wd.save(weight);
	}

	@Override
	public void deleteById(long weightId) {
		wd.delete(weightId);
	}

}
