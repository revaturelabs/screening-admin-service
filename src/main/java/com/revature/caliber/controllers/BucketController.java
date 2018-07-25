package com.revature.caliber.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Bucket;
import com.revature.caliber.services.BucketService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/buckets")
public class BucketController {


	@Autowired
	private BucketService bucketService;
	

	@ApiOperation(value = "Gets a list of all the Buckets", response = Bucket.class, responseContainer = "List")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Bucket>> getAllBuckets() {
		List<Bucket> buckets = bucketService.getAllBuckets();
		return new ResponseEntity<>(buckets, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Adds a new Bucket", response = Bucket.class)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bucket> createBucket(@Valid @RequestBody Bucket bucket) {
		return new ResponseEntity<>(this.bucketService.createBucket(bucket), HttpStatus.CREATED);
	}
	

	@ApiOperation(value = "Updates a Bucket", response = Bucket.class)
	@PutMapping(value = "/{bucketId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bucket> updateBucket(@Valid @RequestBody Bucket bucket) {
		bucketService.updateBucket(bucket);
		return new ResponseEntity<>(bucket, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Gets a Bucket by bucket id", response = Bucket.class)
	@GetMapping(value="/{bucketId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bucket> getBucketByBucketId(@PathVariable Integer bucketId, Bucket bucket) {
		bucket = bucketService.getBucketById(bucketId);
		return new ResponseEntity<>(bucket, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Deletes a Bucket", response = Bucket.class)
	@DeleteMapping(value="/{bucketId}")
	public void deleteBucket(@PathVariable Integer bucketId){
		bucketService.deleteBucket(bucketId);
	}
	
}
	
