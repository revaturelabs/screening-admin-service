package com.revature.caliber.services;

import static org.junit.Assert.*;

import com.revature.caliber.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.revature.caliber.beans.Bucket;

/**
 * Bucket Tests using JUnit
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BucketServiceImplTest {
	@Autowired
	TestEntityManager entityManager;

	@Autowired
	BucketServiceImpl bucketService;

	@Test
	public void testCreateBucketFirst() {
		Bucket bucket = new Bucket();
		System.out.println("this is our bucket--> " + bucket.toString());
		System.out.println("Bucket Method "+ bucketService.getAllBuckets().size());
		int before = bucketService.getAllBuckets().size();
		System.out.println("this is before  " + before);
		bucketService.createBucket(bucket);
		int after = bucketService.getAllBuckets().size();
		System.out.println(before +"  "+after);
		assertEquals(before+1, after);
	}

	@Test
	public void testCreateBucket() {
		this.entityManager.persist(new Bucket(1000,"Test",true));
		assertEquals(1000, bucketService.getBucketById(1000).getBucketId());
	}

	@Test
	public void testCreateNullBucket() {
		System.out.println("Null Bucket Test");
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
