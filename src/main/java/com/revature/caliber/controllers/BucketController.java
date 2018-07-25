package com.revature.caliber.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.caliber.beans.Bucket;
import com.revature.caliber.services.BucketService;
import io.swagger.annotations.ApiOperation;
	
	/**
	 * Controller for the bucket
	 * 
	 * @author Adil Iqbal 	| 1805-WVU-MAY29 | Richard Orr
	 * @author Theo Thompson| 1805-WVU-MAY29 | Richard Orr
	 * @author Josh Dughi 	| 1803-USF-MAR26 | Wezley Singleton
	 */
	
	@RestController
	@RequestMapping(value="/bucket")
	@CrossOrigin
	public class BucketController {



		@Autowired
		private BucketService bucketService;
		
		
		/**
		 * Get a Bucket by category Id
		 * 
		 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
		 * 
		 */
		@ApiOperation(value = "Gets a Bucket by category", response = Bucket.class)
		@GetMapping("/{category_Id}")
		public ResponseEntity<Bucket> getBucketByCategory(@PathVariable(value="category_Id") Integer bucketCategory) {
			Bucket bucket = bucketService.getBucketByCategory(bucketCategory);
			return new ResponseEntity<>(bucket, HttpStatus.OK);
			
		}
		
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
			bucket.setIsActive(true);
			bucketService.createBucket(bucket);
			return new ResponseEntity<>(bucket, HttpStatus.CREATED);
		}
	}
