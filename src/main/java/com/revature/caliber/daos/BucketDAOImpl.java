package com.revature.caliber.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;
import com.revature.caliber.beans.Bucket;

@Repository
public class BucketDAOImpl implements CustomBucketDAO {

	@PersistenceContext
	EntityManager entityManager;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Bucket> getBucketByCategory(Integer bucketCategory) {
		Query query = entityManager.createNativeQuery("SELECT b.* FROM BUCKET as b " +
                "WHERE b.bucket_category LIKE ?", Bucket.class);
		query.setParameter(1, bucketCategory + "%");
		
		return query.getResultList();
	}



}
