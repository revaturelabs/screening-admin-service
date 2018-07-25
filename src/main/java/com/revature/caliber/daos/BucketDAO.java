package com.revature.caliber.daos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.caliber.beans.Bucket;


@Repository
public interface BucketDAO extends JpaRepository<Bucket, Integer>{
	
	
}

