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
    /** Weight repository */
    private WeightRepository weightRepository;

    /**
     * Instantiates a new weight service
     *
     * @param weightRepository Weight repository
     */
    @Autowired
    public WeightServiceImpl(WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    /**
     * Gets ALL the weights
     *
     * @return list of all weights
     */
    @Override
    public List<Weight> getAllWeights() {
        return weightRepository.findAll();
    }

    /**
     * Updates a weight
     *
     * @param weight Updates weight. no return
     */
    @Override
    @Transactional
    public void update(Weight weight) {
        weightRepository.save(weight);
    }

    /**
     * creates new weighted pairing between a Category within a SkillType
     *
     * @param weight Weight object to be persisted
     * @return weight obj after being persisted
     */
    @Override
    @Transactional
    public Weight create(Weight weight) {
        if(weight != null) {
        	return weightRepository.save(weight);
        }else {
        	return null;
        }
    }

    /**
     * Deletes weight based on ID
     *
     * @param weightId No return
     */
    @Override
    @Transactional
    public void deleteById(int weightId) {
        weightRepository.deleteById(weightId);
    }

    /**
     * Gets a list of categories by SkillType
     *
     * @param skillTypeId ID of SkillType to filter by
     * @return List of weights
     */
    @Override
    public List<Weight> getAllWeightsBySkillTypeID(int skillTypeId) {
        return weightRepository.getAllBySkillTypeSkillTypeId(skillTypeId);
    }

    /**
     * Get a weight by its Id
     *
     * @param weightId ID of the weight to filter by
     * @return weight object
     */
    @Override
    public Weight get(int weightId) {
        return weightRepository.findById(weightId).orElse(new Weight());
       
    }

    /**
     * Get a weight by its skillTypeId and categoryId
     *
     * @param skillTypeId ID of skilltype to filter by
     * @param categoryId    ID of category to filter by
     * @return weight object with matching skillTypeId and categoryId
     */
    @Override
    public Weight get(int skillTypeId, int categoryId) {
        return weightRepository.getBySkillTypeSkillTypeIdAndBucketBucketId(skillTypeId, categoryId);
    }

    /**
     * Delete all weights with a specified categoryId
     *
     * @param categoryId CategoryId to filter by
     */
	@Override
	public void deleteAllByCategoryId(int categoryId) {
		weightRepository.deleteAllByCategoryCategoryId(categoryId);
	}

    /**
     * Delete all Categories with matching SkillTypeId
     *
     * @param skillTypeId Id of SkillType to filter by
     */
    @Override
    public void deleteAllBySkillTypeSkillTypeId(int skillTypeId) {
        weightRepository.deleteAllBySkillTypeSkillTypeId(skillTypeId);
    }

    /**
     * Check if id exist
     * @param id ID of weight
     */
	@Override
	public boolean existsById(int weightId) {
		return weightRepository.existsById(weightId);
	}
}
