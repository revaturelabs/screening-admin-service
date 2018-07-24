package com.revature.caliber.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.revature.caliber.beans.Bucket;
import com.revature.caliber.daos.BucketDAO;


@Service
public class BucketServiceImp implements BucketService {
	@Autowired
	private BucketDAO bucketDAO;
	
	//add question bucket
	@Transactional
	@Override
	public Bucket createBucket(Bucket bucket) {
		Bucket buckets = new Bucket();
		return bucketDAO.save(buckets);
	}
}