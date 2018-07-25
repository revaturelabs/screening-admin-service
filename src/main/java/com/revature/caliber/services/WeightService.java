package com.revature.caliber.services;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Weight;


public interface WeightService {

	/**
	 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
	 * @return list of all weights
	 */
	List<Weight> getWeights();


	/**
	 * Weight uses a composite key of skillType and category Ids, this method makes that
	 * composite key and searches for it.
	 * @param skillTypeId
	 * @param categoryId
	 * @return weight corresponding to the skill type and id
	 */
	Weight getWeightBySkillTypeAndCategory(int skillTypeId, int categoryId);

	/**
	 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
	 * @param weight
	 * 
	 * Updates weight. no return
	 */
	void update(Weight weight);

	/**
	 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
	 * creates new weight, creates ID for weight as composite of skillType and Category
	 * @param weight
	 * @return weight obj after being persisted
	 */
	Weight create(Weight weight);

	/**
	 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
	 * Deletes weight based on ID
	 * @param weightId
	 * No return
	 */
	void deleteById(long weightId);

}
