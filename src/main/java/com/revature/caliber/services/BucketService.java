package com.revature.caliber.services;

import com.revature.caliber.beans.Bucket;


/**
 * Interface for our Bucket service layer
 * 
 * @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
 * 
 */
public interface BucketService {
	
	/**
	 * gets a bucket by category id
	 * 
	 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 */
	
	public Bucket getBucketByCategory(Integer bucketCategory);
}