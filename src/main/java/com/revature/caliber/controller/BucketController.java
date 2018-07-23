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
			bucketService.createBucket(bucket);
			return new ResponseEntity<>(bucket, HttpStatus.CREATED);
		}

	}

