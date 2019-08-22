package com.revature.screenforce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.Weight;
import com.revature.screenforce.repositories.WeightRepository;

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
        return weightRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Weight weight) {
        weightRepository.save(weight);
    }

    @Override
    @Transactional
    public Weight create(Weight weight) {
        if(weight != null) {
        	return weightRepository.save(weight);
        }else {
        	return null;
        }
    }

    @Override
    @Transactional
    public void deleteById(int weightId) {
        weightRepository.deleteById(weightId);
    }

    @Override
    public List<Weight> getAllWeightsBySkillTypeID(int skillTypeId) {
        return weightRepository.getAllBySkillTypeSkillTypeId(skillTypeId);
    }

    @Override
    public Weight get(int weightId) {
        return weightRepository.findById(weightId).orElse(new Weight());
       
    }

    @Override
    public Weight get(int skillTypeId, int bucketId) {
        return weightRepository.getBySkillTypeSkillTypeIdAndBucketBucketId(skillTypeId, bucketId);
    }

	@Override
	public void deleteAllByBucketId(int bucketId) {
		weightRepository.deleteAllByBucketBucketId(bucketId);
	}

    @Override
    public void deleteAllBySkillTypeSkillTypeId(int skillTypeId) {
        weightRepository.deleteAllBySkillTypeSkillTypeId(skillTypeId);
    }

	@Override
	public boolean existsById(int id) {
		return weightRepository.existsById(id);
	}
}
