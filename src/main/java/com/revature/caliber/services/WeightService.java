package com.revature.caliber.services;

import com.revature.caliber.beans.Weight;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Defines available methods for WeightService interface
 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
 *
 */
@ApiModel(value = "WeightService", description = "Provides interface to Weight Service Layer")
public interface WeightService {

	/**
	 * Gets ALL the weights
	 * @return list of all weights
	 */
	List<Weight> getAllWeights();

	/**
	 * @param weight
	 * 
	 * Updates weight. no return
	 */
	void update(Weight weight);

	/**
	 * creates new weighted pairing between a Bucket within a SkillType
	 * @param weight
	 * @return weight obj after being persisted
	 */
	Weight create(Weight weight);

	/**
	 * Deletes weight based on ID
	 * @param weightId
	 * No return
	 */
	void deleteById(long weightId);

	/**
	 * Gets a list of buckets by SkillType
	 * @param SkillTypeID ID of SkillType to filter by
	 * @return List of weights
	 */
	List<Weight> getAllBucketsBySkillTypeID(int SkillTypeID);
}
