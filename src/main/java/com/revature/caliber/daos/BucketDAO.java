package com.revature.caliber.daos;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.revature.caliber.beans.Bucket;

public interface BucketDAO extends JpaRepository<Bucket, Integer> {

	
	public Bucket addBucket(Bucket bucket);
	
	public Bucket update(Bucket bucket);
	
	
	public void delete(Bucket bucket);
	
	
	public List<Bucket> findBucketById(Integer bucketId);
	
	
	
	
	/**
	 * Finds a Bucket by it's Bucket category.
	 * 
	 * @author Angelique Elkins | 1803-USF-MAR26 | Wezley Singleton 
	 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param bucketCategory - string value of the Bucket category of Bucket trying to find
	 */
	Bucket findBucketByBucketCategory(Integer bucketCategory);
	
}

      
