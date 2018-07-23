package com.revature.caliber.controllerTest;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.revature.caliber.driver.TestDriver;
import com.revature.caliber.beans.Bucket;

import io.restassured.RestAssured;

/**
 * 
 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
 *
 *	Testing the Bucket Controller with REST-assured.
 *
 */
public class BucketControllerTest extends TestDriver {

	private static Bucket testBucket;
	private static Map<String, String> header;
	List<Bucket> testAll;
	
	/**
	 * 
	 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
	 *
	 *	setUp Method to define default values and connections for the Bucket Controller
	 *
	 */	
	@Before
	public void setUp() throws Exception {
		RestAssured.baseURI = "http://localhost:8090/buckets";
		testBucket = new Bucket("CORE JAVA9","PRIORITY 9 ", false);
		BucketControllerTest.header = new HashMap<String,String>();
		BucketControllerTest.header.put("Content-type", "application/json");
	}

	/**
	 * 
	 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
	 *
	 *	Testing the GET method for all the buckets and see if it does not equal to Zero. 
	 *
	 */	
	@Test
	public final void testGetAllBuckets() {		
		RestAssured.given()
	.when()
		.get()
	.then()
		.assertThat()
			.statusCode(200);
	}
	
	/**
	 * 
	 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
	 *
	 *	Testing the GET method by bucketId and see if it does not equal to Zero by the length. 
	 *
	 */
	
	@Test
	public final void testGetBucketByBucketId() {		
		RestAssured.given()
		.when()
			.get("/1")
		.then()
			.assertThat()
				.statusCode(200);
	}
	
	/**
	 * 
	 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
	 *
	 *	Testing the to see if able to Create a New Bucket Successfully.
	 *
	 */	
	@Ignore
	@Test
	public final void testCreateNewBucket() {			
		RestAssured.given()
			.headers(header)
			.body(testBucket)
			.when()
				.post()
			.then()
				.assertThat()
					.statusCode(201);
	}
	
	/**
	 * 
	 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
	 *
	 *	Testing the to see if able to Update a Bucket Successfully.
	 *
	 */	
	
	@Test
	public final void testUpdateBucket() {		
		testBucket.setBucketId(9);
		testBucket.setBucketCategory("JUNIT TEST");
		testBucket.setBucketDescription("JUNIT TEST");
		testBucket.setIsActive(false);
		
		RestAssured.given()
			.headers(header)
			.body(testBucket)
			.when()
				.put()
			.then()
				.assertThat()
					.statusCode(200);
	}
}
