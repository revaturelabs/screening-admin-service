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
	private BucketDAO bucketDAO;
	private QuestionService questionService;
	private WeightService weightService;

	@Autowired
	public BucketServiceImpl(BucketDAO bd, QuestionService qs, WeightService ws) {
		this.bucketDAO = bd;
		this.questionService = qs;
		this.weightService = ws;
	}
	
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

	@Override
	public List<Bucket> getAllBuckets() {
		List<Bucket> buckets = new ArrayList<>();
		bucketRepository.findAll().forEach(buckets::add);
		return buckets;
	}	

	@Override
	@Transactional
	public void updateBucket(Bucket bucket) {
		if(!bucket.getBucketDescription().isEmpty()) {
			bucketRepository.save(bucket);
		}
	}
	
	@Override
	@Transactional
	public void deleteBucket(int bucketId) {
		weightService.deleteAllByBucketId(bucketId);
		questionService.deleteByBucketId(bucketId);
		bucketRepository.deleteById(bucketId);
	}
	
	@Override
	public Bucket getBucketById(int bucketId) {
		return bucketRepository.findById(bucketId).orElse(new Bucket());
	}

	@Override
	public boolean existsById(int bid) {
		return bucketRepository.existsById(bid);
	}
	
}
