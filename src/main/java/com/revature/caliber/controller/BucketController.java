package com.revature.caliber.controller;

	import java.util.List;
	import javax.validation.Valid;
	import org.apache.log4j.Logger;
	import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
	import org.springframework.http.MediaType;
	import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Bucket;

	import com.revature.caliber.services.BucketService;
	import io.swagger.annotations.ApiOperation;
	
	/**
	 * Controller for the bucket
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 */
	
	@RestController

	@RequestMapping(value="/bucket")

	@CrossOrigin
	@ComponentScan("com.revature.caliber.*")
	public class BucketController {

		private static final Logger log = Logger.getLogger(BucketController.class);

		@Autowired
		private BucketService bucketService;
		
		/**
		 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
		 * 
		 * Get list of all the Buckets
		 * 
		 * @return list of all Buckets
		 */
		/*
		@ApiOperation(value = "Gets a list of all the Buckets", response = Bucket.class, responseContainer = "List")
		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Bucket>> getAllBuckets() {
			List<Bucket> buckets = bucketService.getAllBuckets();
			return new ResponseEntity<>(buckets, HttpStatus.OK);
		}
		*/
		/**
		 * Creates a new Bucket
		 * 
		 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
		 * 
		 * @param bucket - the new Bucket
		 * @return created Bucket
		 */

	
		
		@ApiOperation(value = "Creates a new Bucket")
		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Bucket> createBucket(@Valid @RequestBody Bucket bucket) {
			log.info("Saving bucket:" + bucket);
			bucket.setIsActive(true);
			bucketService.save(bucket);

			
			return new ResponseEntity<>(bucket, HttpStatus.CREATED);
		}
		
		/**
		 * Get a single Bucket by bucketId
		 * 
		 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
		 * 
		 * @param id - id of Bucket
		 * @return Bucket of given id
		 */
		/*
		@ApiOperation(value = "Gets a Bucket by bucket id", response = Bucket.class)
		@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Bucket> getBucketById(@PathVariable Integer bucketId) {
			Bucket bucket = bucketService.getBucketById(bucketId);
			return new ResponseEntity<>(bucket, HttpStatus.OK);
		}
		*/
		
		@ApiOperation(value = "Gets a Bucket by category", response = Bucket.class)
		@GetMapping("/{id}")
		public ResponseEntity<Bucket> getBucketByCategory(@PathVariable(value="id") Integer bucketCategory) {
			Bucket bucket = bucketService.getBucketByCategory(bucketCategory);
			log.trace("working");
			return new ResponseEntity<>(bucket, HttpStatus.OK);
			
		}
		
		
		/*
		@ApiOperation(value = "Gets a Bucket by category", response = Bucket.class)
		 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
		    @ResponseBody
		    public ResponseEntity<Bucket> getBucketByCategory(@PathVariable Integer bucketCategory) {
				Bucket bucket = bucketService.getBucketByCategory(bucketCategory);
				return new ResponseEntity<>(bucket, HttpStatus.OK);
			}
		*/
		/*
		@GetMapping(value = "/{id}")
		@ResponseBody
		public Bucket getBucketByCategory(@PathVariable Integer bucketCategory) {
			Bucket bucket = bucketService.getBucketByCategory(bucketCategory);
			return bucket;
		}
		*/
		/**
		 * Updates a Bucket
		 * 
		 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
		 * 
		 * @param bucket - updated Bucket 
		 * @return updated Bucket
		 */
		/*
		@ApiOperation(value = "Updates a Bucket", response = Bucket.class)
		@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Bucket> updateBucket(@RequestBody Bucket bucket) {
			bucketService.updateBucket(bucket);
			return new ResponseEntity<>(bucket, HttpStatus.OK);
		}
		*/

	}

