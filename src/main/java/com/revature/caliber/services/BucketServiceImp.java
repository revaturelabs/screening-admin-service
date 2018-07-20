package com.revature.caliber.services;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.revature.caliber.beans.QuestionBucket;
//import com.revature.gambit.messaging.Sender;
import com.revature.caliber.daos.QuestionBucketDAO;

import zipkin2.reporter.Sender;
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
	QuestionBucketDAO bucketDAO;
	
	@Autowired
	private Sender sender;
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
*/
	@Override
	public List<QuestionBucket> getAllBuckets() {
		log.debug("Find all Buckets");
		return bucketDAO.findAll();
	}

	@Override
	public QuestionBucket getBucketById(Integer bucketId) {
		log.debug("Find Bucket By BucketId");
		return bucketDAO.findOne(bucketId);
	}
	//find bucket by category
	@Override
	public QuestionBucket getBucketByCategory(Integer bucketCategory) {
		log.debug("Find Bucket By categoryId");
		return bucketDAO.findOne(bucketCategory);
	}
	
	//add question bucket
	@Transactional
	@Override
	public QuestionBucket createBucket(QuestionBucket questionbucket) {
		QuestionBucket bucket = new QuestionBucket();
		return bucketDAO.save(questionbucket);
	}

	@Transactional
	@Override
	public QuestionBucket updateBucket(QuestionBucket bucket) {
		QuestionBucket bucketExists = bucketDAO.findOne(bucket.getBucketId());
		if(bucketExists == null) {
			return null;
		} else {
			return bucketDAO.save(bucket);
		}
	}

	@Override
	public QuestionBucket save(QuestionBucket bucket) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}