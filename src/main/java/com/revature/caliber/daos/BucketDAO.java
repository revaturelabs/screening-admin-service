package com.revature.caliber.daos;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import com.revature.caliber.beans.Bucket;


@Repository
public interface BucketDAO extends JpaRepository<Bucket, Integer>{
	/*
	//add new question bucket
	@Modifying
	@Query("insert into Bucket b values (b.bucket_Id = :bucket_Id, b.category_Id = :category_Id, b.bucket_description = :bucket_description, b.is_active = :is_active, b.skill_type_id = :skill_type_id)")
	public Bucket createBucket(@Param("bucket_Id") Integer bucketId, @Param("category_Id") Integer bucketCategory, @Param("bucket_description") String bucketDescription, @Param("is_active") Boolean isActive, @Param("skill_type_id") Integer skillTypeId);
	
	//get all question buckets
	@Query("select b from Bucket b")
	public List<Bucket> getAllBuckets();
	
	//get question bucket by id number
	@Query("select b from Bucket b where bucket_id = :bucket_id")
	public Bucket getBucketById(@Param("bucket_id")Integer bucketId);
	*/
	//get question bucket by bucket category
	@Query("select b from Bucket b where category_Id = :category_Id")
	public Bucket getBucketByCategory(@Param("category_Id")Integer bucketCategory);


}