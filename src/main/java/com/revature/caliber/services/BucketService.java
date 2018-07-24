package com.revature.caliber.services;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Bucket;


/**
 * Interface for our Bucket service layer
 *  
 * @author Angelique Elkins | 1803-USF-MAR26 | Wezley Singleton 
 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
 */
@Service
public interface BucketService {

	public Bucket createBucket(Bucket bucket);
}

