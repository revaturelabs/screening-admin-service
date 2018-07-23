package com.revature.caliber.services;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.caliber.beans.Bucket;
import com.revature.caliber.daos.BucketDAO;
//import com.revature.gambit.messaging.Sender;


//import zipkin2.reporter.Sender;
//import static com.revature.gambit.util.MessagingUtil.TOPIC_CREATE_BUCKET_ID;

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
	BucketDAO bucketDAO;
	
	//@Autowired
	//private Sender sender;
	/*
	@Transactional
	@Override
	public QuestionBucket save(QuestionBucket bucket) {
		log.debug("save Bucket");
		
		if(bucket.getBucketCategory().equals("")) {
			return null;
		}
		QuestionBucket bucketExists = bucketDAO.findBucketByBucketCategory(bucket.getBucketCategory());
		if(bucketExists != null) {
			return null;
		} else {
			QuestionBucket savedBucket = bucketDAO.save(bucket);
			if(savedBucket != null) {
				sender.publish(TOPIC_CREATE_BUCKET_ID, savedBucket.getBucketId());
			}
			return savedBucket;
		}
	}

	/*
	@Override
	public List<Bucket> getAllBuckets() {
		log.debug("Find all Buckets");
		return bucketDAO.findAll();
	}
*/
	/*
	@Override
	public Bucket getBucketById(Integer bucketId) {
		log.debug("Find Bucket By BucketId");
		return bucketDAO.findOne(bucketId);
	}
	*/
	//find bucket by category
	@Override
	public Bucket getBucketByCategory(Integer bucketCategory) {
		log.debug("Find Bucket By categoryId");
		//switch(bucketCategory) {
		//case 1: Bucket b = new Bucket(1,1,"hello", true);
		//	return b;	
		//}
		//return null;
		return bucketDAO.findOne(bucketCategory);
	}
	
	//add question bucket
	@Transactional
	@Override
	public Bucket createBucket(Bucket bucket) {
		Bucket buckets = new Bucket();
		return bucketDAO.save(buckets);
	}

	/*
	@Transactional
	@Override
	public Bucket updateBucket(Bucket bucket) {
		Bucket bucketExists = bucketDAO.findOne(bucket.getBucketId());
		if(bucketExists == null) {
			return null;
		} else {
			return bucketDAO.save(bucket);
		}
	}
*/
	
	@Override
	public Bucket save(Bucket bucket) {
		bucketDAO.save(bucket);
		return bucket;
	}

	
	
}