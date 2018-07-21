package com.revature.caliber.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Bucket;


@Repository
public interface BucketDAO extends CrudRepository<Bucket,Integer>, CustomBucketDAO {

}
