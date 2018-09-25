package com.revature.caliber.services;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.revature.caliber.beans.Bucket;

/**
 * Bucket Tests using JUnit
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 */

public class BucketServiceImplTest {
	
	@Autowired
	BucketServiceImpl bucketService;

	@Test
	public void testCreateBucket() {
		Bucket bucket = new Bucket();
		int before = bucketService.getAllBuckets().size();
		bucketService.createBucket(bucket);
		int after = bucketService.getAllBuckets().size();
		assertEquals(before+1, after);
	}
	@Test
	public void testCreateNullBucket() {
		assertEquals(null, bucketService.createBucket(null));
	}

	@Test
	public void testGetAllBuckets() {
		Bucket bucket = new Bucket();
		int maxB = bucketService.getAllBuckets().size();
		bucketService.createBucket(bucket);
		assertEquals((maxB +1), bucketService.getAllBuckets().size());
	}

	@Test
	public void testUpdateBucket() {
		Bucket bucket = new Bucket();
		bucketService.createBucket(bucket);
		String des = bucket.getBucketDescription();
		String newDes = "new Description";
		bucket.setBucketDescription(newDes);
		assertEquals(newDes, bucketService.getBucketById(bucket.getBucketId()).getBucketDescription());
	}

	@Test
	public void testDeleteBucket() {
		Bucket bucket = new Bucket();
		int before = bucketService.getAllBuckets().size();
		bucketService.createBucket(bucket);
		bucketService.deleteBucket(bucket.getBucketId());
		int after = bucketService.getAllBuckets().size();
		assertEquals(before, after);
	}

	@Test
	public void testGetBucketById() {
		Bucket bucket = new Bucket();
		int id = bucketService.createBucket(bucket).getBucketId();
		assertEquals(id, bucketService.getBucketById(id));
	}

}
