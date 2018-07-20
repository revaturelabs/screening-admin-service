package com.revature.caliber.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.QuestionBucket;


@Repository
public interface QuestionBucketDAO extends JpaRepository<QuestionBucket, Integer>{
	
	@Query("insert into BUCKET (bucket_id, bucket_category, bucket_description, is_active, skill_type_id) values (?,?,?,?,?)")
	public int createBucket(QuestionBucket questionbucket);
	
	@Query("select * from BUCKET")
	public List<QuestionBucket> getAllBuckets();
	
	//byid
	@Query("select * from BUCKET where bucket_id = ?")
	public QuestionBucket getBucketById(Integer bucketId);
	
	//bycategory
	@Query("select * from BUCKET where bucket_category = ?")
	public QuestionBucket getBucketByCategory(Integer bucketCategory);


	
	//update
	
	//delete
	

}
