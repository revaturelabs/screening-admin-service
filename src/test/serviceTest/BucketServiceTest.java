package com.revature.caliber.serviceTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.caliber.TestDriver;
import com.revature.caliber.beans.Bucket;
import com.revature.caliber.daos.BucketDAO;
import com.revature.caliber.services.BucketService;
import com.revature.caliber.services.BucketServiceImp;

/**
 * 
 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
 *
 *	Testing the BucketService with Mockito.
 *
 */
public class BucketServiceTest extends TestDriver {
	
	static BucketDAO myBucketDAO;
	static BucketService myBucketService;
	List<Bucket> myTestList;
	Bucket bucket1, bucket2, bucket3;
	
	/**
	 * 
	 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
	 *
	 *	setUpBeforeClass Method to define Mockito.
	 *
	 */		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myBucketDAO = mock(BucketDAO.class);
		myBucketService = mock(BucketServiceImp.class);
	}
	
	/**
	 * 
	 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
	 *
	 *	tearDownAfterClass Method to define null.
	 *
	 */	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		myBucketDAO = null;
		myBucketService = null;
	}
	
	/**
	 * 
	 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
	 *
	 *	setUp Method to define default values.
	 *
	 */	
	@Before
	public void setUp() {
		bucket1 = new Bucket(1,"CORE JAVA1","PRIORITY 1 ", true);
		bucket2 = new Bucket(2,"CORE JAVA2","PRIORITY 2 ", false);
		bucket3 = new Bucket(3,"CORE JAVA3","PRIORITY 3 ", true);
		myTestList = new ArrayList<Bucket>();
		myTestList.add(bucket1);
		myTestList.add(bucket2);
	}
	
	/**
	 * 
	 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
	 *
	 *	tearDown Method to define default to null.
	 *
	 */	
	@After
	public void tearDown() {
		myTestList.removeAll(myTestList);
		myTestList = null;
		bucket1 = null;
		bucket2 = null;
		bucket3 = null;		
	}
	
	/**
	 * 
	 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
	 *
	 *	testGetAllBuckets Method to get all the buckets.
	 *
	 */	
	/*
	@Test
	public final void testGetAllBuckets() {
		when(myBucketDAO.findAll()).thenReturn(myTestList);
		assertNotNull(myBucketService.getAllBuckets());
	}
	*/
	/**
	 * 
	 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
	 *
	 *	testGetBucketByBucketId Method to get bucket by id.
	 *
	 */	
	/*
	@Test
	public final void testGetBucketByBucketId() {		
		when(myBucketService.findBucketByBucketId(1)).thenReturn(bucket1);
		assertSame(myBucketService.findBucketByBucketId(1), bucket1);
		assertNotNull(myBucketService.findBucketByBucketId(1));

	}
	*/
	@Test
	public final void testGetBucketByCategory() {		
		when(myBucketService.getBucketByCategory(1)).thenReturn(bucket1);
		assertSame(myBucketService.getBucketByCategory(1), bucket1);
		assertNotNull(myBucketService.getBucketByCategory(1));

	}
	
	
	
	/**
	 * 
	 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
	 *
	 *	testCreateNewBucket Method to creating a new bucket.
	 *
	 */	
	/*
	@Test
	public final void testCreateNewBucket() {		
		when(myBucketService.save(bucket3)).thenReturn(bucket3);
		assertNotNull(myBucketService.save(bucket3));
	}
	*/
	/**
	 * 
	 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
	 *
	 *	testUpdateBucket Method to update a bucket.
	 *
	 */
	/*
	@Test
	public final void testUpdateBucket() {		
		when(myBucketService.updateBucket(bucket1)).thenReturn(bucket1);
		assertNotNull(myBucketService.updateBucket(bucket1));
	}
	*/
}
