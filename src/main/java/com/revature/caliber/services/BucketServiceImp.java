package com.revature.caliber.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Bucket;
import com.revature.caliber.services.BucketService;
import com.revature.caliber.daos.BucketDAO;


/**
 * Implementation for our Bucket service layer
 *  
 *  @author adil iqbal 		| 1805-WVU-MAY29 | Richard Orr
 *  @author Theo Thompson 	| 1805-WVU-MAY29 | Richard Orr
 */
@Service
public class BucketServiceImp implements BucketService {


	@Autowired
	BucketDAO bucketDAO;
	/**
	 * find bucket by category
	 * @see com.revature.caliber.services.BucketService#getBucketByCategory(java.lang.Integer)
	 */
	
	@Override
	public Bucket getBucketByCategory(Integer bucketCategory) {
		return bucketDAO.getBucketByBucketCategory(bucketCategory);
		
	}
	
	@Transactional
	@Override
	public Bucket createBucket(Bucket bucket) {
		Bucket buckets = new Bucket();
		return bucketDAO.save(buckets);
	}
}