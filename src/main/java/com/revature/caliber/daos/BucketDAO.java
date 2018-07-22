package com.revature.caliber.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.revature.caliber.beans.Bucket;


@Repository
public interface BucketDAO extends JpaRepository<Bucket, Integer>{
	
	//add new question bucket
	//@Modifying
	//@Query("insert into Bucket (bucket_id, bucket_category, bucket_description, is_active, skill_type_id) values (:bucket_id,:bucket_categor,:bucket_description,:is_active, :skill_type_id)")
	//public Bucket createBucket(@Param("bucket_id") Integer bucketId, @Param("bucket_category") Integer bucketCategory, @Param("bucket_description") String bucketDescription, @Param("is_active") Boolean isActive, @Param("skill_type_id") Integer skillTypeId);
	
	//get all question buckets
	//@Query("select b from Bucket b")
	//public List<Bucket> getAllBuckets();
	
	//get question bucket by id number
	//@Query("select b from Bucket b where bucket_id = :bucket_id")
	//public Bucket getBucketById(@Param("bucket_id")Integer bucketId);
	
	//get question bucket by bucket category
	@Query("select b from Bucket b where bucket_category = :bucket_category")
	public Bucket getBucketByCategory(@Param("bucket_category")Integer bucketCategory);


	
	//update
	
	//delete
	

}