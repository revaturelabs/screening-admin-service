package com.revature.caliber.daos;

import java.util.List;

import com.revature.caliber.beans.Bucket;

public interface CustomBucketDAO {
	
	List<Bucket> getBuckeyByCategory(Integer bucketCategory);
	
}
