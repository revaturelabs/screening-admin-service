package com.revature.screenforce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.repositories.BucketRepository;

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
	/** Bucket repository */
	private BucketRepository bucketRepository;

	/** Question service */
	private QuestionService questionService;

	/** Weight service */
	private WeightService weightService;

	/**
	 * Instantiates a new bucket service
	 *
	 * @param bucketRepository Bucket repository
	 * @param questionService Question service
	 * @param weightService Weight service
	 */
	@Autowired
	public BucketServiceImpl(BucketRepository bucketRepository,
							 QuestionService questionService,
							 WeightService weightService) {
		this.bucketRepository = bucketRepository;
		this.questionService = questionService;
		this.weightService = weightService;
	}

	/**
	 * creates a new bucket in the DB
	 * @param bucket - a new bucket
	 * @return Bucket obj w/ updated id
	 */
	@Transactional
	@Override
	public Bucket createBucket(Bucket bucket) {
		if(bucket != null && bucket != new Bucket()) {
			return bucketRepository.save(bucket);
		} 
		else {
			return null;
		}
	}

	/**
	 * Fetches all buckets
	 * @return list of buckets
	 */
	@Override
	public List<Bucket> getAllBuckets() {
		List<Bucket> buckets = new ArrayList<>();
		bucketRepository.findAll().forEach(buckets::add);
		return buckets;
	}

	/**
	 * Updates bucket information
	 * @param bucket - bucket to update
	 */
	@Override
	@Transactional
	public void updateBucket(Bucket bucket) {
		if(!bucket.getBucketDescription().isEmpty()) {
			bucketRepository.save(bucket);
		}
	}

	/**
	 * Removes a bucket with the specified Id
	 * @param bucketId - id of the bucket to be deleted
	 * No return
	 */
	@Override
	@Transactional
	public void deleteBucket(int bucketId) {
		weightService.deleteAllByBucketId(bucketId);
		questionService.deleteByBucketId(bucketId);
		bucketRepository.deleteById(bucketId);
	}

	/**
	 * Gets a bucket by its Id
	 * @param bucketId Id of bucket to filter by
	 * @return bucket or null if id is not found
	 */
	@Override
	public Bucket getBucketById(int bucketId) {
		return bucketRepository.findById(bucketId).orElse(new Bucket());
	}

	/**
	 * Check if id exist
	 * @param bid Bucket ID
	 */
	@Override
	public boolean existsById(int bid) {
		return bucketRepository.existsById(bid);
	}
}
