package com.revature.caliber.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.revature.caliber.beans.Bucket;
import com.revature.caliber.daos.BucketDAO;


@Service
public class BucketServiceImp implements BucketService {
	
	@Autowired
	private BucketDAO bucketDAO;
	
	
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
	public void updateBucket(Bucket bucket) {
		bucketDAO.save(bucket);
	}
	
	@Override
	public void deleteBucket(Integer bucketId) {
		bucketDAO.delete(bucketId);
	}
	
	@Override
	public Bucket getBucketById(Integer bucketId) {
		return bucketDAO.findOne(bucketId);
	}
}