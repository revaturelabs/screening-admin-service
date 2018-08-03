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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
	
/**
 * Controller for the bucket
 * 
 * @author Adil Iqbal 	| 1805-WVU-MAY29 | Richard Orr
 * @author Theo Thompson| 1805-WVU-MAY29 | Richard Orr
 * @author Josh Dughi 	| 1803-USF-MAR26 | Wezley Singleton
 */
@RestController
@RequestMapping(value="/bucket")
@ApiModel(value = "BucketController", description = "A rest controller to handle HTTP Requests made to /bucket")
public class BucketController {

	@Autowired
	private BucketService bucketService;	

	/**
	 * Gets all Buckets
	 * @return List of Buckets and Http status code 
	 */
	@ApiOperation(value = "Gets a list of all the Buckets", response = Bucket.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "All Buckets returned") } )
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Bucket>> getAllBuckets() {
		List<Bucket> buckets = bucketService.getAllBuckets();
		return new ResponseEntity<>(buckets, HttpStatus.OK);
	}	
	
	/**
	 * Creates a new bucket
	 * @param bucket - transient bucket
	 * @return Detached bucket (w/ updated Id) and http status code
	 */
	@ApiOperation(value = "Adds a new Bucket", response = Bucket.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created bucket returned") } )
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bucket> createBucket(@Valid @RequestBody Bucket bucket) {
		return new ResponseEntity<>(this.bucketService.createBucket(bucket), HttpStatus.CREATED);

	}	

	/**
	 * Updates a bucket located at "/id"
	 * @param bucket - the updated bucket
	 * @return Updated bucket and http status code
	 */
	@ApiOperation(value = "Updates a Bucket", response = Bucket.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Bucket updated") } )
	@PutMapping(value = "/{bucketId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bucket> updateBucket(@Valid @RequestBody Bucket bucket) {
		bucketService.updateBucket(bucket);
		return new ResponseEntity<>(bucket, HttpStatus.OK);
	}
	
	/**
	 * Gets an individual bucket
	 * @param bucketId - Id of bucket to fetch
	 * @return Requested bucket and http status code
	 */
	@ApiOperation(value = "Gets a Bucket by bucket id", response = Bucket.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Requested bucket returned") } )
	@GetMapping(value="/{bucketId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bucket> getBucketByBucketId(@PathVariable Integer bucketId) {
		Bucket bucket = bucketService.getBucketById(bucketId);
		return new ResponseEntity<>(bucket, HttpStatus.OK);
	}
	
	/**
	 * Deletes a bucket
	 * @param bucketId - Id of bucket to delete
	 * @return http status 204
	 */
	@ApiOperation(value = "Deletes a Bucket")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Bucket deleted") } )
	@DeleteMapping(value="/{bucketId}")
	public ResponseEntity<Void> deleteBucket(@PathVariable Integer bucketId){
		bucketService.deleteBucket(bucketId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
	