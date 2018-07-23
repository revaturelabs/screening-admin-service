package com.revature.caliber.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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
	
	
	//add question bucket
	@Transactional
	@Override
	public Bucket createBucket(Bucket bucket) {
		Bucket buckets = new Bucket();
		return bucketDAO.save(buckets);
	}

	

	

	
	
	
}