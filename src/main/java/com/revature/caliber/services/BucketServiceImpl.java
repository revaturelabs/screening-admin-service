package com.revature.caliber.services;

import com.revature.caliber.beans.Bucket;
import com.revature.caliber.daos.BucketDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


/**
 * Implementation for our Bucket service layer
 *  
 *  @author adil iqbal 		| 1805-WVU-MAY29 | Richard Orr
 *  @author Theo Thompson 	| 1805-WVU-MAY29 | Richard Orr
 *  @author Rishabh Rana 	| 1807-QC | Emily Higgins
 *  @author Alpha Barry 	| 1807-QC | Emily Higgins
 */
@Service
public class BucketServiceImpl implements BucketService {

	@Autowired
	BucketDAO bucketDAO;
	
	@Transactional
	@Override
	public Bucket createBucket(Bucket bucket) {
		if(bucket != null && bucket != new Bucket()) {
			return bucketDAO.save(bucket);
		} 
		else {
			return null;
		}
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
		if(!bucket.getBucketDescription().isEmpty()) {
			bucketDAO.save(bucket);
		}
	}
	
	@Override
	@Transactional
	public void deleteBucket(int bucketId) {
		bucketDAO.deleteById(bucketId);
	}
	
	@Override
	public Bucket getBucketById(int bucketId) {
		return bucketDAO.findById(bucketId).orElse(new Bucket());
	}
	
}
