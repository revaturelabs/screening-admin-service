package com.revature.caliber.services;

import java.util.List;
import io.swagger.annotations.ApiModel;

import com.revature.caliber.beans.Weight;

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
	List<Weight> getWeights();

	/**
	 * Weight uses a composite key of skillType and category Ids, this method makes that
	 * composite key and searches for it.
	 * @param skillTypeId
	 * @param categoryId
	 * @return weight corresponding to the skill type and id or null if not found
	 */
	Weight getWeightBySkillTypeAndCategory(int skillTypeId, int categoryId);

	/**
	 * @param weight
	 * 
	 * Updates weight. no return
	 */
	void update(Weight weight);

	/**
	 * creates new weight, creates ID for weight as composite of skillType and Category
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

}
