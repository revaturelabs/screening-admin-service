package com.revature.caliber.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Bucket;
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
	
	@Transactional
	@Override
	public Bucket createBucket(Bucket bucket) {
		return bucketDAO.save(bucket);
	}

	@Override
	public List<Bucket> getAllBuckets() {
		List<Bucket> buckets = new ArrayList<>();
		bucketDAO.findAll().forEach(buckets::add);
		return buckets;
	}	

	@Override
	@Transactional
	public void updateBucket(Bucket bucket) {
		bucketDAO.save(bucket);
	}
	
	@Override
	@Transactional
	public void deleteBucket(Integer bucketId) {
		bucketDAO.delete(bucketId);
	}
	
	@Override
	public Bucket getBucketById(Integer bucketId) {
		return bucketDAO.findOne(bucketId);
	}
	
}
