package com.revature.screenforce.services;

import io.swagger.annotations.ApiModel;

import java.util.List;

import com.revature.screenforce.beans.Track;

/**
 * Defines available methods for the Track service interface
 * 
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */
@ApiModel(value = "TrackService", description = "Provides interface for Track service layer")
public interface TrackService {

	/**
	 * Method that returns all Tracks
	 * @return list of track objects
	 */
	public List<Track> getAllTracks();
	
	/**
	 * Method that returns all active Tracks
	 * @return list of Track objects
	 */
	public List<Track> getActiveTracks(boolean b);
	
	/**
	 * Method that returns a specific Track
	 * @param id the primary key of the Track
	 * @return an individual track
	 */
	public Track getTrack(int id);
	
	/**
	 * Creates a new track
	 * @param s transient track
	 * @return detached track
	 */
	public Track createTrack(Track s);
	
	/**
	 * Updates a skill's title
	 * @param s existing skill object w/ updated title
	 */
	public void updateTrack(Track s);
	
	/**
	 * Removes skill with specified Id
	 * @param id primary key of skill to review
	 */
	public void deleteTrack(int id);

	
	/**
	 * Gets the skill by its id
	 * @param trackId primary key of skill to get
	 */
	public Track getTrackById(int trackId);
	
	/**
	 * Check if id exist
	 * @param id ID of skill type
	 */
	public boolean existsById(int id);
}
