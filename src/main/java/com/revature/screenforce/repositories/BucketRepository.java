package com.revature.screenforce.repositories;

import org.springframework.stereotype.Repository;

import com.revature.screenforce.beans.Bucket;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * DAO Repository for Bucket utilizing
 * JpaRepository & CrudRepository interface methods
 *  
 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
 */

@Repository
public interface BucketRepository extends JpaRepository<Bucket, Integer>{
	
}

