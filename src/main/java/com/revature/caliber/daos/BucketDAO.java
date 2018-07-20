package com.revature.caliber.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Bucket;


@Repository
public interface BucketDAO extends JpaRepository<Bucket, Integer>{
	
	@Query("insert into BUCKET (bucket_id, bucket_category, bucket_description, is_active, skill_type_id) values (?,?,?,?,?)")
	public int createBucket(Bucket questionbucket);
	
	@Query("select * from BUCKET")
	public List<Bucket> getAllBuckets();
	
	//byid
	@Query("select * from BUCKET where bucket_id = ?")
	public Bucket getBucketById(Integer bucketId);
	
	//bycategory
	@Query("select * from BUCKET where bucket_category = ?")
	public Bucket getBucketByCategory(Integer bucketCategory);


	
	//update
	
	//delete
	

}
