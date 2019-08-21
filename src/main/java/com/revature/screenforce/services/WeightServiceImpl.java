package com.revature.screenforce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.Weight;
import com.revature.screenforce.daos.WeightDAO;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Provides implementation for the weight service layer
 *
 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
 */
@Service
public class WeightServiceImpl implements WeightService {
    private WeightDAO wd;

    @Autowired
	public WeightServiceImpl(WeightDAO wd) {
    	this.wd = wd;
	}

    @Override
    public List<Weight> getAllWeights() {
        return wd.findAll();
    }

    @Override
    @Transactional
    public void update(Weight weight) {
        wd.save(weight);
    }

    @Override
    @Transactional
    public Weight create(Weight weight) {
        if(weight != null) {
        	return wd.save(weight);
        }else {
        	return null;
        }
    }

    @Override
    @Transactional
    public void deleteById(int weightId) {
        wd.deleteById(weightId);
    }

    @Override
    public List<Weight> getAllWeightsBySkillTypeID(int skillTypeId) {
        return wd.getAllBySkillTypeSkillTypeId(skillTypeId);
    }

    @Override
    public Weight get(int weightId) {
        return wd.findById(weightId).orElse(new Weight());
       
    }

    @Override
    public Weight get(int skillTypeId, int bucketId) {
        return wd.getBySkillTypeSkillTypeIdAndBucketBucketId(skillTypeId, bucketId);
    }

	@Override
	public void deleteAllByBucketId(int bucketId) {
		wd.deleteAllByBucketBucketId(bucketId);
	}

    @Override
    public void deleteAllBySkillTypeSkillTypeId(int skillTypeId) {
        wd.deleteAllBySkillTypeSkillTypeId(skillTypeId);
    }

	@Override
	public boolean existsById(int id) {
		return wd.existsById(id);
	}
}
