package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


/**
 * Define bucket POJO
 *
 * @author Adil Iqbal | 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 * @author Omar Guzman | 1807-QC | Emily Higgins
 */
@ApiModel(value = "Bucket", description = "A Bucket which holds a set of related Questions")
@Entity
@Table(name = "bucket")
public class Bucket implements Serializable {

    private static final long serialVersionUID = 2435095816452768808L;

    /** ID of the bucket */
    @ApiModelProperty(value = "id of the Bucket")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUCKET_SEQUENCE")
    @SequenceGenerator(name = "BUCKET_SEQUENCE", sequenceName = "bucket_sequence", allocationSize = 1)
    @Column(name = "BUCKET_ID")
    private int bucketId;

    /** Description of the bucket */
    @ApiModelProperty(value = "description of the Bucket")
    @Column(name = "BUCKET_DESCRIPTION")
    private String bucketDescription;

    /** Denotes whether bucket is active or not */
    @ApiModelProperty(value = "denotes whether Bucket is active or not")
    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    /**
     * Instantiates a new bucket
     */
    public Bucket() {
        super();
    }

    /**
     * Instantiates a new bucket
     *
     * @param bucketId ID of bucket
     * @param bucketDescription Description of bucket
     * @param isActive Is bucket active?
     */
    public Bucket(Integer bucketId, String bucketDescription, Boolean isActive) {
        super();
        this.bucketId = bucketId;
        this.bucketDescription = bucketDescription;
        this.isActive = isActive;
    }

    /**
     * Returns the bucket ID
     *
     * @return Bucket ID
     */
    public int getBucketId() {
        return bucketId;
    }

    /**
     * Set bucket ID
     *
     * @param bucketId Bucket ID
     */
    public void setBucketId(int bucketId) {
        this.bucketId = bucketId;
    }

    /**
     * Returns bucket description
     *
     * @return Bucket description
     */
    public String getBucketDescription() {
        return bucketDescription;
    }

    /**
     * Sets bucket description
     *
     * @param bucketDescription Bucket description
     */
    public void setBucketDescription(String bucketDescription) {
        this.bucketDescription = bucketDescription;
    }

    /**
     * Returns if bucket is active
     *
     * @return Bucket's active state
     */
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * Change the active state of the bucket
     *
     * @param isActive Bucket's active state
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Compares equality between buckets
     *
     * @param o Bucket to compare
     * @return True if buckets are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return getBucketId() == bucket.getBucketId() &&
                isActive == bucket.isActive &&
                Objects.equals(getBucketDescription(), bucket.getBucketDescription());
    }

    /**
     * Returns hashcode of bucket
     *
     * @return Hashcore
     */
    @Override
    public int hashCode() {
        return Objects.hash(getBucketId(), getBucketDescription(), isActive);
    }

    /**
     * Converts bucket to string
     *
     * @return String representation of bucket
     */
    @Override
    public String toString() {
        return "Bucket{" +
                "bucketId=" + bucketId +
                ", bucketDescription='" + bucketDescription + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
