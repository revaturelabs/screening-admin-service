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
	 * @param track transient track
	 * @return detached track
	 */
	public Track createTrack(Track track);
	
	/**
	 * Updates a track's title
	 * @param track existing track object w/ updated title
	 */
	public void updateTrack(Track track);
	
	/**
	 * Removes track with specified Id
	 * @param trackId primary key of track to review
	 */
	public void deleteTrack(int trackId);

	
	/**
	 * Gets the track by its id
	 * @param trackId primary key of track to get
	 */
	public Track getTrackById(int trackId);
	
	/**
	 * Check if track with specified id exists
	 * @param trackId
	 */
	public boolean existsById(int trackId);
}
