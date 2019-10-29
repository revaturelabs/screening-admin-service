package com.revature.screenforce.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.Track;
import com.revature.screenforce.repositories.TrackRepository;

/**
 * Implementation for the Track service interface
 * 
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */
@Service
public class TrackServiceImpl implements TrackService {
	private TrackRepository trackRepository;
	/** Weight service */
	private WeightService weightService;

	/**
	 * Instantiates a new Track service
	 *
	 * @param trackRepository Track repository
	 * @param weightService Weight service
	 */
	@Autowired
	public TrackServiceImpl(TrackRepository trackRepository,
								WeightService weightService) {
		this.trackRepository = trackRepository;
		this.weightService = weightService;
	}

	/**
	 * Method that returns all Tracks
	 * @return list of track objects
	 */
	@Override
	public List<Track> getAllTracks() {
		return trackRepository.findAll();
	}

	/**
	 * Creates a new track
	 * @param track transient track
	 * @return detached track
	 */
	@Override
	@Transactional
	public Track createTrack(Track track) {
		return trackRepository.save(track);
	}

	/**
	 * Method that returns a specific Track
	 * @param trackId the primary key of the Track
	 * @return an individual track
	 */
	@Override
	public Track getTrack(int trackId) {
		return trackRepository.findById(trackId).orElse(null);
	}

	/**
	 * Updates a Track
	 * @param track existing Track object w/ updated values
	 */
	@Override
	@Transactional
    public void updateTrack(Track track) {
        trackRepository.saveOnly(track.getTrackId(), track.getTitle(), track.isActive());
    }

	/**
	 * Removes track with specified Id
	 * @param trackId
	 */
	@Override
	@Transactional
	public void deleteTrack(int trackId) {
		weightService.deleteAllByTrackTrackId(trackId);
		trackRepository.deleteById(trackId);
	}

	/**
	 * Method that returns all active Tracks
	 * @param b active state of Tracks to return
	 * @return list of Track objects
	 */
	@Override
	public List<Track> getActiveTracks(boolean b) {
		return trackRepository.findAllByIsActive(b);
	}

	/**
	 * Gets a Track by its id
	 * @param trackId primary key of Track to get
	 */
	@Override
	public Track getTrackById(int trackId) {
		return trackRepository.findById(trackId).orElse(null);
	}

	/**
	 * Check if Track with specified id exists
	 * @param trackId
	 */
	@Override
	public boolean existsById(int trackId) {
		return trackRepository.existsById(trackId);
	}
}
