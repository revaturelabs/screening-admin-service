package com.revature.caliber.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import com.revature.caliber.beans.Bucket;
/**
 * DAOs for our Bucket
 *  
 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
 */

@Repository
public interface BucketDAO extends JpaRepository<Bucket, Integer>{
	/**
	 * get question bucket by bucket category
	 *  
	 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 */

	public Bucket getBucketByBucketCategory( Integer bucketCategory);


}