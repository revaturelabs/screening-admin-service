package com.revature.screenforce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.screenforce.beans.Track;

/**
 * DAO Repository for the Track utilizing
 * JpaRepository & CrudRepository interface methods
 * 
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */
@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
	
	/**
	 * Gets all active or inactive Track objects
	 * 
	 * @param b the boolean determining active status
	 * @return list of Track objects
	 */
	public List<Track> findAllByIsActive(boolean b);

	/**
	 * Updates a track type by ID
	 *
	 * @param id ID of track type
	 * @param title Name of track type
	 * @param b Active state of track type
	 */
    @Modifying
    @Query("update Track s set s.title = ?2, s.isActive = ?3 where s.trackId = ?1")
    public void saveOnly(int id, String title, Boolean b);
}
