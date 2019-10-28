package com.revature.screenforce.services;

import io.swagger.annotations.ApiModel;

import java.util.List;

import com.revature.screenforce.beans.Weight;

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
	 * Updates a weight
	 *
	 * @param weight Updates weight. no return
	 */
	void update(Weight weight);

	/**
	 * creates new weighted pairing between a category within a Track
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
	void deleteById(int weightId);

	/**
	 * Gets a list of categoriess by Track
	 *
	 * @param trackId ID of Track to filter by
	 * @return List of weights
	 */
	List<Weight> getAllWeightsByTrackID(int trackId);

	/**
	 * Get a weight by its Id
	 *
	 * @param weightId ID of the weight to filter by
	 * @return weight object
	 */
	Weight get(int weightId);

	/**
	 * Get a weight by its trackId and categoryId
	 *
	 * @param trackId    ID of track to filter by
	 * @param categoryId ID of category to filter by
	 * @return weight object with matching trackId and categoryId
	 */
	Weight get(int trackId, int categoryId);

	/**
	 * Delete all weights with a specified categoryId
	 *
	 * @param categoryId categoryId to filter by
	 */
	void deleteAllByCategoryId(int categoryId);

	/**
	 * Delete all Categories with matching TrackId
	 *
	 * @param trackId Id of Track to filter by
	 */
	void deleteAllByTrackTrackId(int trackId);

	/**
	 * Check if id exist
	 * 
	 * @param id ID of weight
	 */
	public boolean existsById(int weightId);
}
