package com.revature.caliber.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.caliber.beans.Bucket;

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
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBucket() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

}
