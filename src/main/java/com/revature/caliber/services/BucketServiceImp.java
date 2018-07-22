package com.revature.caliber.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Bucket;
import com.revature.caliber.daos.BucketDAO;

//import com.revature.gambit.messaging.Sender;


/**
 * Implementation for our Bucket service layer
 *  
 * @author Angelique Elkins | 1803-USF-MAR26 | Wezley Singleton 
 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
 */
@Service
public class BucketServiceImp implements BucketService {

	private static final Logger log = Logger.getLogger(BucketServiceImp.class);

	@Autowired
	private BucketDAO bucketDAO;

	@Override
	public Bucket save(Bucket bucket) {
		bucketDAO.save(bucket);
		return bucket;
	}

	@Override
	public List<Bucket> getAllBuckets() {
		List<Bucket> buckets = new ArrayList<>();
		bucketDAO.findAll().forEach(buckets::add);
		return buckets;
	}

	@Override
	public Bucket getBucketById(Integer bucketId) {
		return bucketDAO.findOne(bucketId);
	}

	@Override
	public Bucket getBucketByCategory(Integer bucketCategory) {
		return bucketDAO.findOne(bucketCategory);
	}

	@Override
	public Bucket createBucket(Bucket questionbucket) {
		bucketDAO.save(questionbucket);
		return questionbucket;
	}

	@Override
	public Bucket updateBucket(Bucket bucket) {
		bucketDAO.save(bucket);
		return bucket;
	}
	
	
	
}