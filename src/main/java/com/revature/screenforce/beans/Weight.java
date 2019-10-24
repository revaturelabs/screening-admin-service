package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;


/**
 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 * @author Omar Guzman | 1807-QC | Emily Higgins
 *
 * POJO for the weight object
 */
@ApiModel(value = "Weight", description = "Weights for Buckets within a Track, determining how a Bucket contributes to the final score")
@Entity
@Table(name = "WEIGHT")
public class Weight {
    /** Weight ID */
    @ApiModelProperty(value = "The weightId - primary key for the table")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WEIGHT_ID")
    private int weightId;

    /** Weight needed for calculations */
    @ApiModelProperty(value = "The actual weight needed for calculation")
    @Column(name = "WEIGHT_VALUE")
    private int weightValue;

    /** Track object */
    @ApiModelProperty(value = "the Track Id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TRACK_ID")
    private Track track;

    /** Bucket object */
    @ApiModelProperty(value = "The Bucket Id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BUCKET_ID")
    private Bucket bucket;

    /**
     * Instantiates a new weight
     */
    public Weight() {
        super();
    }

    /**
     * Instantiates a new weight
     *
     * @param weightId Weight ID
     * @param weightValue Weight value
     * @param track Track
     * @param bucket Bucket
     */
    public Weight(int weightId, int weightValue, Track track, Bucket bucket) {
        super();
        this.weightId = weightId;
        this.weightValue = weightValue;
        this.track = track;
        this.bucket = bucket;
    }

    /**
     * Returns ID for weight
     *
     * @return Weight ID
     */
    public int getWeightId() {
        return weightId;
    }

    /**
     * Sets ID for weight
     *
     * @param weightId Weight ID
     */
    public void setWeightId(int weightId) {
        this.weightId = weightId;
    }

    /**
     * Returns weight value
     *
     * @return Weight value
     */
    public int getWeightValue() {
        return weightValue;
    }

    /**
     * Sets weight value
     *
     * @param weightValue Weight value
     */
    public void setWeightValue(int weightValue) {
        this.weightValue = weightValue;
    }

    /**
     * Returns track
     *
     * @return Track
     */
    public Track getTrack() {
        return track;
    }

    /**
     * Sets track
     *
     * @param track Track
     */
    public void setTrack(Track track) {
        this.track = track;
    }

    /**
     * Returns bucket
     *
     * @return Bucket
     */
    public Bucket getBucket() {
        return bucket;
    }

    /**
     * Sets bucket
     *
     * @param bucket Bucket
     */
    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    /**
     * Tests equality between weights
     *
     * @param o Weight to be compared
     * @return True if weights are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight1 = (Weight) o;
        return getWeightId() == weight1.getWeightId() &&
                getWeightValue() == weight1.getWeightValue() &&
                getTrack() == weight1.getTrack() &&
                getBucket() == weight1.getBucket();
    }

    /**
     * Returns weight hashcode
     *
     * @return Hashcode for weight
     */
    @Override
    public int hashCode() {
        return Objects.hash(getWeightId(), getWeightValue(), getTrack(), getBucket());
    }

    /**
     * Converts weight object to string
     *
     * @return String representation of weight
     */
    @Override
    public String toString() {
        return "Weight{" +
                "weightId=" + weightId +
                ", weightValue=" + weightValue +
                ", track=" + track +
                ", bucket=" + bucket +
                '}';
    }
}
