package com.revature.caliber.services;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.caliber.beans.Bucket;
import com.revature.caliber.daos.BucketDAO;

/**
 * Implementation for our Bucket service layer
 *  
 * @author adil iqbal | 1805-WVU-MAY29 |
 */
@Service
public class BucketServiceImp implements BucketService {

	private static final Logger log = Logger.getLogger(BucketServiceImp.class);

	@Autowired
	BucketDAO bucketDAO;
	/*
	 * find bucket by category
	 * @see com.revature.caliber.services.BucketService#getBucketByCategory(java.lang.Integer)
	 */
	
	@Override
	public Bucket getBucketByCategory(Integer bucketCategory) {
		log.debug("Find Bucket By categoryId");
		return bucketDAO.getBucketByCategory(bucketCategory);
		/*
		switch(bucketCategory) {
		case 1: Bucket b = new Bucket(1,1,"hello", true);
			return b;	
		}
		return null;
		*/
	}
	
}