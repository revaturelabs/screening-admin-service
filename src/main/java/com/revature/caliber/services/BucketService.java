package com.revature.caliber.services;
import java.util.List;
import com.revature.caliber.beans.Bucket;


/**
 * Interface for our Bucket service layer
 *  
 * @author Angelique Elkins | 1803-USF-MAR26 | Wezley Singleton 
 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
 */
public interface BucketService {

	/**
	 * Saves given Bucket to database
	 * 
	 * @author Angelique Elkins | 1803-USF-MAR26 | Wezley Singleton 
	 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param bucket - Bucket to save
	 * @return saved Bucket
	 */
	//public Bucket save(Bucket bucket);

	/**
	 * Returns all Buckets
	 * 
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @return all Buckets
	 */
	//public List<Bucket> getAllBuckets();

	/**
	 * Returns Bucket of given id
	 * 
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param bucketId - the id of the Bucket being located
	 * @return the Bucket whose id was matched; return null if not found
	 */
	//public Bucket getBucketById(Integer bucketId);

	/**
	 * Updates given Bucket to database
	 * 
	 * @author Angelique Elkins | 1803-USF-MAR26 | Wezley Singleton
	 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param bucket - updated Bucket
	 * @return updated Bucket
	 */
	public Bucket getBucketByCategory(Integer bucketCategory);
	
	//public Bucket createBucket(Bucket questionbucket);
	//public Bucket updateBucket(Bucket bucket);
}