package com.revature.caliber.controllers;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import com.revature.caliber.beans.Bucket;
	import com.revature.caliber.services.BucketService;
	import io.swagger.annotations.ApiOperation;
	
	/**
	 * Controller for the bucket
	 * 
	 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 *  
	 */
	
	@RestController
	@RequestMapping(value="/bucket")
	@CrossOrigin
	@ComponentScan("com.revature.caliber.*")
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
		
		
	}
