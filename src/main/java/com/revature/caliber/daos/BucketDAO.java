package com.revature.caliber.daos;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.caliber.beans.Bucket;
/**
 * DAO Repository for Bucket utilizing
 * JpaRepository & CrudRepository interface methods
 *  
 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
 */

@Repository
public interface BucketDAO extends JpaRepository<Bucket, Integer>{
	
}

