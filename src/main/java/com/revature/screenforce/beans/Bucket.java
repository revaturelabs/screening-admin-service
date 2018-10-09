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

    @ApiModelProperty(value = "id of the Bucket")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUCKET_SEQUENCE")
    @SequenceGenerator(name = "BUCKET_SEQUENCE", sequenceName = "bucket_sequence", allocationSize = 1)
    @Column(name = "BUCKET_ID")
    private int bucketId;

    @ApiModelProperty(value = "description of the Bucket")
    @Column(name = "BUCKET_DESCRIPTION")
    private String bucketDescription;

    @ApiModelProperty(value = "denotes whether Bucket is active or not")
    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    public Bucket() {
        super();
    }

    public Bucket(Integer bucketId, String bucketDescription, Boolean isActive) {
        super();
        this.bucketId = bucketId;
        this.bucketDescription = bucketDescription;
        this.isActive = isActive;
    }

    /**
     * Getters & Setters
     */
    public int getBucketId() {
        return bucketId;
    }

    public void setBucketId(int bucketId) {
        this.bucketId = bucketId;
    }

    public String getBucketDescription() {
        return bucketDescription;
    }

    public void setBucketDescription(String bucketDescription) {
        this.bucketDescription = bucketDescription;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return getBucketId() == bucket.getBucketId() &&
                isActive == bucket.isActive &&
                Objects.equals(getBucketDescription(), bucket.getBucketDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBucketId(), getBucketDescription(), isActive);
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "bucketId=" + bucketId +
                ", bucketDescription='" + bucketDescription + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}

