package com.revature.screenforce.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.ScreeningAdminServiceApplication;
import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.services.BucketServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Bucket Tests using JUnit
 *
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScreeningAdminServiceApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class BucketServiceImplTest {

	@Autowired
	BucketServiceImpl bucketService;

	@Test
	public void testCreateBucketFirst() {
		Bucket bucket = new Bucket();
		int before = bucketService.getAllBuckets().size();
		bucketService.createBucket(bucket);
		int after = bucketService.getAllBuckets().size();
		assertEquals(before + 1, after);
	}

	@Test
	public void testCreateNullBucket() {
		Bucket bucket = null;
		int before = bucketService.getAllBuckets().size();
		bucketService.createBucket(bucket);
		int after = bucketService.getAllBuckets().size();
		assertEquals(before, after);
		
	}

	@Test
	public void testGetAllBuckets() {
		Bucket bucket = new Bucket();
		int maxB = bucketService.getAllBuckets().size();
		bucketService.createBucket(bucket);
		assertEquals((maxB + 1), bucketService.getAllBuckets().size());
	}

	@Test
	public void testUpdateBucket() {
		Bucket b = bucketService.getBucketById(404);
		String newDes = "Updated Description Test";
		b.setBucketDescription(newDes);
	    bucketService.updateBucket(b);
		assertEquals(newDes, bucketService.getBucketById(404).getBucketDescription());
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
		assertEquals(id, bucketService.getBucketById(id).getBucketId());
	}

	@Test
	public void testExistById() {
		assertTrue(bucketService.existsById(406));
	}
	

	@Test
	public void testExistByIdFail() {
		assertFalse(bucketService.existsById(4061));
	}
}
