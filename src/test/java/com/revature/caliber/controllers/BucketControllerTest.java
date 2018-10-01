package com.revature.caliber.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.caliber.Application;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BucketControllerTest {

	/*
	@Test
	public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {
	        
	    given().
	    when().
	        get("http://ergast.com/api/f1/2017/circuits.json").
	    then().
	        assertThat().
	        body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
	}
	*/
	@Test
	public void testGetAllBuckets() {
		
	}
/*
	@Test
	public void testCreateBucket() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBucket() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBucketByBucketId() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteBucket() {
		fail("Not yet implemented");
	}*/

}
