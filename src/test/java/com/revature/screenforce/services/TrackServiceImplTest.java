package com.revature.screenforce.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Track;
import com.revature.screenforce.repositories.TrackRepository;

/**
 * TrackService Tests using JUnit
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 * @author Omar Guzman | 1807-QC | Emily Higgins
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TrackServiceImplTest {
	@Mock TrackRepository trackRepository;
	@Mock WeightService weightService;
	@InjectMocks TrackServiceImpl trackService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllTracks() {
		List<Track> tracks = new ArrayList<>();

		// Mock DAO findAll()
		when(trackRepository.findAll()).thenReturn(tracks);

		int nTracks = tracks.size();
		assertEquals(nTracks, trackService.getAllTracks().size());
	}

	@Test
	public void testCreateTrack() {
		// Mock DAO save()
		when(trackRepository.save(any(Track.class))).thenReturn(new Track());
		assertNotNull(trackService.createTrack(new Track()));
	}

	@Test
	public void testGetTrack() {
		Track skill = new Track("Intelligence", true);

		// Mock DAO findById()
		when(trackRepository.findById(any(Integer.class)))
				.thenReturn(java.util.Optional.of(skill));
		
		assertEquals(skill,
				trackService.getTrack(skill.getTrackId()));
	}

	@Test
	public void testUpdateTrack() {
		Track track = new Track();
		track.setTitle("Title");

		// Mock DAO findById() & save()
		when(trackRepository.findById(any(Integer.class)))
				.thenReturn(java.util.Optional.of(track));
		when(trackRepository.save(any(Track.class))).thenReturn(track);

		Track st = trackService.createTrack(track);
		st.setTitle("Updated Title");
		trackService.updateTrack(st);

		assertEquals(st, trackService.getTrackById(st.getTrackId()));
	}

	@Test
	public void testDeleteTrack() {
		List<Track> skills = new ArrayList<>();
		Track track = new Track();
		track.setTrackId(4);

		// Mock DAO save() & findById()
		when(trackRepository.findById(any(Integer.class)))
				.thenReturn(java.util.Optional.of(track));
		when(trackRepository.save(any(Track.class))).thenReturn(track);
		skills.add(trackService.createTrack(track));

		// Mock DAO deleteById()
		trackService.deleteTrack(track.getTrackId());
		skills.remove(track);

		when(trackRepository.findAll()).thenReturn(skills);
		assertEquals(skills.size(), trackService.getAllTracks().size());
	}

	@Test
	public void testGetActiveTracks() {
		List<Track> skills = new ArrayList<>();
		Track track = new Track("test", true);

		// Mock DAO save()
		when(trackRepository.save(any(Track.class))).thenReturn(track);
		skills.add(trackService.createTrack(track));

		// Mock DAO findAllByIsActive()
		when(trackRepository.findAllByIsActive(any(Boolean.class))).thenReturn(skills);

		assertEquals(skills.size(),
				trackService.getActiveTracks(true).size());
	}

	@Test
	public void testExistById() {
		when(trackRepository.existsById(any(Integer.class))).thenReturn(true);
		assertTrue(trackService.existsById(51));
	}
	
	@Test
	public void testExistByIdFail() {
		when(trackRepository.existsById(any(Integer.class))).thenReturn(false);
		assertFalse(trackService.existsById(511));
	}
}
