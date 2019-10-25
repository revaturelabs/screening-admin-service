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
	 * Instantiates a new skill type service
	 *
	 * @param trackRepository Skill type repository
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
	 * @param s transient track
	 * @return detached track
	 */
	@Override
	@Transactional
	public Track createTrack(Track s) {
		return trackRepository.save(s);
	}

	/**
	 * Method that returns a specific Track
	 * @param id the primary key of the Track
	 * @return an individual track
	 */
	@Override
	public Track getTrack(int id) {
		return trackRepository.findById(id).orElse(null);
	}

	/**
	 * Updates a skill's title
	 * @param s existing skill object w/ updated title
	 */
	@Override
	@Transactional
    public void updateTrack(Track s) {
        trackRepository.saveOnly(s.getTrackId(), s.getTitle(), s.isActive());
    }

	/**
	 * Removes skill with specified Id
	 * @param id primary key of skill to review
	 */
	@Override
	@Transactional
	public void deleteTrack(int id) {
		weightService.deleteAllByTrackTrackId(id);
		trackRepository.deleteById(id);
	}

	/**
	 * Method that returns all active Tracks
	 * @return list of Track objects
	 */
	@Override
	public List<Track> getActiveTracks(boolean b) {
		return trackRepository.findAllByIsActive(b);
	}

	/**
	 * Gets the skill by its id
	 * @param trackId primary key of skill to get
	 */
	@Override
	public Track getTrackById(int trackId) {
		return trackRepository.findById(trackId).orElse(null);
	}

	/**
	 * Check if id exist
	 * @param id ID of skill type
	 */
	@Override
	public boolean existsById(int id) {
		return trackRepository.existsById(id);
	}
}
