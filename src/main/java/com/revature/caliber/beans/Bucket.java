package com.revature.caliber.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Define bucket POJO
 *  
 * @author Adil Iqbal | 1805-WVU-MAY29 | Richard Orr
 */
@ApiModel(value = "Bucket", description = "A Bucket which holds a set of related Questions")
@Component
@Entity
@Table(name = "bucket")
public class Bucket implements Serializable {

	private static final long serialVersionUID = 2435095816452768808L;
	
	@ApiModelProperty(value = "id of the Bucket")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUCKET_SEQUENCE")
	@SequenceGenerator(name = "BUCKET_SEQUENCE", sequenceName = "bucket_sequence", allocationSize=1)
	@Column(name = "BUCKET_ID")
	private Integer bucketId;

	@ApiModelProperty(value = "description of the Bucket")
	@Column(name = "BUCKET_DESCRIPTION")
	private String bucketDescription;

	@ApiModelProperty(value = "denotes whether Bucket is active or not")
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

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
	public Integer getBucketId() {
		return bucketId;
	}

	public void setBucketId(Integer bucketId) {
		this.bucketId = bucketId;
	}

	public String getBucketDescription() {
		return bucketDescription;
	}

	public void setBucketDescription(String bucketDescription) {
		this.bucketDescription = bucketDescription;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bucketDescription == null) ? 0 : bucketDescription.hashCode());
		result = prime * result + ((bucketId == null) ? 0 : bucketId.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		return result;
	}

	 @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bucket other = (Bucket) obj;
		if (bucketDescription == null) {
			if (other.bucketDescription != null)
				return false;
		} else if (!bucketDescription.equals(other.bucketDescription))
			return false;
		if (bucketId == null) {
			if (other.bucketId != null)
				return false;
		} else if (!bucketId.equals(other.bucketId))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bucket [bucketId=" + bucketId + ", bucketDescription="
				+ bucketDescription + ", isActive=" + isActive + "]";
	}
	
}

