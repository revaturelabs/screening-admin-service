package com.revature.screenforce.controllers;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.services.BucketService;

import javax.validation.Valid;
import java.util.List;
	
/**
 * Controller for the bucket
 * @author Adil Iqbal 	| 1805-WVU-MAY29 | Richard Orr
 * @author Theo Thompson| 1805-WVU-MAY29 | Richard Orr
 * @author Josh Dughi 	| 1803-USF-MAR26 | Wezley Singleton
 */
@RestController
@CrossOrigin
@RequestMapping(value="/bucket")
@ApiModel(value = "BucketController", description = "A rest controller to handle HTTP Requests made to /bucket")
public class BucketController {

	private BucketService bucketService;	
	
	public BucketController(BucketService bucketService){
		this.bucketService = bucketService;
	}

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
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created bucket returned"),
			@ApiResponse(code = 415, message = "Unsupported Media")
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bucket> createBucket(@Valid @RequestBody Bucket bucket) {
		if (bucket != null && !bucket.getBucketDescription().equals("")) {
			return new ResponseEntity<>(this.bucketService.createBucket(bucket), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		}
	}	

	/**
	 * Updates a bucket located at "/id"
	 * @param bucket - the updated bucket
	 * @return Updated bucket and http status code
	 */
	@ApiOperation(value = "Updates a Bucket", response = Bucket.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Bucket updated"),
			@ApiResponse(code = 400, message = "Bad Request, Bucket not updated")
			} )
	@PutMapping(value = "/{bucketId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bucket> updateBucket(@PathVariable(value = "bucketId") int bucketId, @RequestBody Bucket bucket) {
		if (bucketService.existsById(bucketId)) {
			bucketService.updateBucket(bucket);
			return new ResponseEntity<>(bucket, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Gets an individual bucket
	 * @param bucketId - Id of bucket to fetch
	 * @return Requested bucket and http status code
	 */
	@ApiOperation(value = "Gets a Bucket by bucket id", response = Bucket.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Requested bucket returned"),
			@ApiResponse(code = 404, message = "Bucket not found")
	} )
	@GetMapping(value="/{bucketId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bucket> getBucketByBucketId(@PathVariable Integer bucketId) {
		Bucket bucket = bucketService.getBucketById(bucketId);
		if (bucket.equals(new Bucket())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(bucket, HttpStatus.OK);
		}
	}
	
	/**
	 * Deletes a bucket
	 * @param bucketId - Id of bucket to delete
	 * @return http status 204
	 */
	@ApiOperation(value = "Deletes a Bucket")
	@ApiResponses(value = { 
			@ApiResponse(code = 204, message = "Bucket deleted"),
			@ApiResponse(code = 404, message = "Bucket Not Found, Nothing is Deleted") } )
	@DeleteMapping(value="/{bucketId}")
	public ResponseEntity<Void> deleteBucket(@PathVariable Integer bucketId){
		if (bucketService.existsById(bucketId)) {
			bucketService.deleteBucket(bucketId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}	
}
	
