package com.revature.caliber.services;

import com.revature.caliber.beans.Weight;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Defines available methods for WeightService interface
 *
 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
 */
@ApiModel(value = "WeightService", description = "Provides interface to Weight Service Layer")
public interface WeightService {

	/**
	 * Gets ALL the weights
	 *
	 * @return list of all weights
	 */
	List<Weight> getAllWeights();

	/**
	 * @param weight Updates weight. no return
	 */
	void update(Weight weight);

	/**
	 * creates new weighted pairing between a Bucket within a SkillType
	 *
	 * @param weight Weight object to be persisted
	 * @return weight obj after being persisted
	 */
	Weight create(Weight weight);

	/**
	 * Deletes weight based on ID
	 *
	 * @param weightId No return
	 */
	void deleteById(long weightId);

	/**
	 * Gets a list of buckets by SkillType
	 *
	 * @param SkillTypeID ID of SkillType to filter by
	 * @return List of weights
	 */
	List<Weight> getAllWeightsBySkillTypeID(int SkillTypeID);

	/**
	 * Get a weight by its Id
	 *
	 * @param weightId ID of the weight to filter by
	 * @return weight object
	 */
	Weight get(long weightId);

	/**
	 * Get a weight by its skillTypeId and bucketId
	 *
	 * @param skillTypeId ID of skilltype to filter by
	 * @param bucketId    ID of bucket to filter by
	 * @return weight object with matching skillTypeId and bucketId
	 */
	Weight get(int skillTypeId, int bucketId);

	/**
	 * Delete all weights with a specified bucketId
	 *
	 * @param bucketId BucketId to filter by
	 */
	void deleteAllByBucketId(int bucketId);
}
