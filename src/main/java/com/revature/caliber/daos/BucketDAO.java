package com.revature.caliber.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import com.revature.caliber.beans.Bucket;
/**
 * DAOs for our Bucket
 *  
 * @author adil iqbal | 1805-WVU-MAY29 |
 */

@Repository
public interface BucketDAO extends JpaRepository<Bucket, Integer>{
	/**
	 * get question bucket by bucket category
	 *  
	 * @author adil iqbal | 1805-WVU-MAY29 |
	 */
	@Query("select b from Bucket b where category_Id = :category_Id")
	public Bucket getBucketByCategory(@Param("category_Id")Integer bucketCategory);


}