package com.revature.screenforce.beans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Outlines the Track POJO
 * 
 * @author Isaac Pawling | 1085-WVU | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@ApiModel(value = "Track", description = "Track corresponding to an overall training track, associated with a number of Buckets")
@Entity
@Table(name = "TRACK")
public class Track implements Serializable {

	private static final long serialVersionUID = -6863562903787298483L;

	/** ID of the track */
	@ApiModelProperty(value = "Track id")
	@Id
	@SequenceGenerator(name = "trackSeq", sequenceName = "TRACK_SEQUENCE", allocationSize=1)
	@GeneratedValue(generator = "trackSeq", strategy = GenerationType.SEQUENCE)
	@Column(name = "TRACK_ID")
	private int trackId;

	/** Name of the track */
	@ApiModelProperty(value = "Name of the track")
	@Column(name = "TITLE")
	private String title;

	/** Active state of the track */
    @ApiModelProperty(value = "is the Track currently active")
    @Column(name = "is_active")
    private boolean isActive;

	/**
	 * Instantiates a new track
	 */
	public Track() {
		super();
	}

	/**
	 * Instantiates a new track
	 *
	 * @param title Name of the track
	 * @param isActive Active state of the track
	 */
	public Track(String title, boolean isActive) {
		this.title = title;
		this.isActive = isActive;
	}

	/**
	 * Returns unique class version ID
	 *
	 * @return Unique class version ID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * Returns track ID
	 *
	 * @return ID of track
	 */
	public int getTrackId() {
		return trackId;
	}

	/**
	 * Sets ID for track
	 *
	 * @param trackId Track ID
	 */
	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	/**
	 * Returns track name
	 *
	 * @return Name of track
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets track name
	 *
	 * @param title Name of track
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns active state of track
	 *
	 * @return Active state of track
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Sets active state of track
	 *
	 * @param isActive Active state of track
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Compares track objects for equality
	 *
	 * @param o Track to compare
	 * @return True if tracks are equal, false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Track track = (Track) o;
		return getTrackId() == track.getTrackId() &&
				isActive() == track.isActive() &&
				Objects.equals(getTitle(), track.getTitle());
	}

	/**
	 * Returns hashcode of track
	 *
	 * @return Hashcode of track
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getTrackId(), getTitle(), isActive());
	}

	/**
	 * Converts track to string
	 *
	 * @return String representation of track
	 */
	@Override
	public String toString() {
		return "Track{" +
				"trackId=" + trackId +
				", title='" + title + '\'' +
				", isActive=" + isActive +
				'}';
	}
}
