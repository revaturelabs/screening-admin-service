package com.revature.screenforce.services;

import com.revature.screenforce.repositories.BucketRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Bucket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Bucket Tests using JUnit
 *
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BucketServiceImplTest {
	@Mock BucketRepository bucketRepository;
	@Mock QuestionService questionService;
	@Mock WeightService weightService;
	@InjectMocks private CategoryServiceImpl bucketService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateBucketFirst() {
		// Mock DAO save()
		when(bucketRepository.save(any(Bucket.class))).thenReturn(new Bucket());
		assertNotNull(bucketService.createBucket(new Bucket()));
	}

	@Test
	public void testCreateNullBucket() {
		// Mock DAO save()
		when(bucketRepository.save(any(Bucket.class))).thenReturn(null);

		Bucket bucket = null;
		assertNull(bucketService.createBucket(bucket));
	}

	@Test
	public void testGetAllBuckets() {
		List<Bucket> buckets = new ArrayList<>();

		// Mock DAO findAll()
		when(bucketRepository.findAll()).thenReturn(buckets);

		int nBuckets = buckets.size();
		assertEquals(nBuckets, bucketService.getAllBuckets().size());
	}

	@Test
	public void testUpdateBucket() {
		Bucket bucket = new Bucket();
		bucket.setBucketId(404);
		bucket.setBucketDescription("Description");

		// Mock DAO findById() & save()
		when(bucketRepository.findById(bucket.getBucketId()))
				.thenReturn(java.util.Optional.of(bucket));
		when(bucketRepository.save(any(Bucket.class))).thenReturn(bucket);

		Bucket b = bucketService.getBucketById(404);
		String description = "Updated Description";
		b.setBucketDescription(description);
	    bucketService.updateBucket(b);

		assertEquals(description, bucketService.getBucketById(404)
				.getBucketDescription());
	}

	@Test
	public void testDeleteBucket() {
		Bucket bucket = new Bucket();

		// Mock DAO save() & findById()
		when(bucketRepository.save(bucket)).thenReturn(bucket);
		when(bucketRepository.findById(any(Integer.class)))
				.thenReturn(Optional.of(new Bucket()));

		bucket = bucketService.createBucket(bucket);
		bucket.setBucketId(404);
		bucketService.deleteBucket(bucket.getBucketId());

		// getBucketById is set to return new Bucket() if no bucket with ID is
		// found
		assertEquals(new Bucket(),
				bucketService.getBucketById(bucket.getBucketId()));
	}

	@Test
	public void testGetBucketById() {
		Bucket bucket = new Bucket();
		bucket.setBucketId(404);

		// Mock DAO findById()
		when(bucketRepository.findById(bucket.getBucketId())).
				thenReturn(java.util.Optional.of(bucket));

		assertEquals(bucket.getBucketId(),
				bucketService.getBucketById(bucket.getBucketId()).getBucketId());
	}

	@Test
	public void testExistById() {
		when(bucketRepository.existsById(any(Integer.class))).thenReturn(true);
		assertTrue(bucketService.existsById(406));
	}

	@Test
	public void testExistByIdFail() {
		when(bucketRepository.existsById(any(Integer.class))).thenReturn(false);
		assertFalse(bucketService.existsById(4061));
	}
}
