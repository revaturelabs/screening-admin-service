package com.revature.screenforce.controllers;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.screenforce.beans.Track;
import com.revature.screenforce.services.TrackService;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller that handles mapping for Track manipulation
 * 
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */
@RestController
@RequestMapping(value = "/track")
@ApiModel(value = "TrackController", description = "A rest controller to handle HTTP Requests made to /track")
public class TrackController {
	/** Track service */
	private TrackService trackService;

	/**
	 * Instantiates a new track controller
	 *
	 * @param trackService Track service
	 */
	@Autowired
	public TrackController(TrackService trackService) {
		this.trackService = trackService;
	}

	/**
	 * Gets all tracks
	 * 
	 * @return List of all Track objects
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Gets list of Tracks", response = Track.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "All Tracks returned") })
	public ResponseEntity<List<Track>> getTracks() {
		return new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.OK);
	}

	/**
	 * Gets all active tracks
	 * 
	 * @return List of all active Track objects
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/active")
	@ApiOperation(value = "Gets list of active Tracks", response = Track.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "All active Tracks returned") })
	public ResponseEntity<List<Track>> getActiveTracks() {
		return new ResponseEntity<>(trackService.getActiveTracks(true), HttpStatus.OK);
	}

	/**
	 * Gets requested Id
	 * 
	 * @return Track object and Http status code 200 if found, 404 otherwise
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Gets a Track by id", response = Track.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Requested Track returned"),
			@ApiResponse(code = 404, message = "Requested Track not found") })
	public ResponseEntity<Track> getTrackById(@PathVariable(value = "id") Integer id) {
		Track track = trackService.getTrack(id);
		if (track == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(track, HttpStatus.OK);
		}
	}

	/**
	 * Creates a track
	 *
	 * @param s Track object to create
	 * @return Track w/ updated Id and Http status code 200, updating track with
	 *         empty title results in 406
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a Track", response = Track.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Track created"),
			@ApiResponse(code = 406, message = "Track must have a title") })
	public ResponseEntity<Track> postTrack(@Valid @RequestBody Track track) {
		if (track.getTitle().equals("")) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(trackService.createTrack(track), HttpStatus.CREATED);
	}

	/**
	 * Updates track located at "/id"
	 *
	 * @param s Track object to update
	 * @return Http status code 202, 404 if track type w/ provided Id DNE
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Puts a Track by id", response = Track.class)
	@ApiResponses(value = { @ApiResponse(code = 202, message = "Track updated"),
			@ApiResponse(code = 404, message = "Track not found") })
	public ResponseEntity<Void> putTrackById(@PathVariable(value = "id") int id, @RequestBody Track track) {
		if (trackService.existsById(id)) {
			trackService.updateTrack(track);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Deletes a track
	 *
	 * @param id ID of track to delete
	 * @return Http status code 404 if Track DNE, 204 otherwise
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Deletes a Track by id", response = Track.class)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Track deleted"),
			@ApiResponse(code = 404, message = "Track not found") })
	public ResponseEntity<Void> deleteTrackById(@PathVariable(value = "id") int id) {
		Track track = trackService.getTrack(id);
		if (track != null) {
			trackService.deleteTrack(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
