package com.revature.caliber.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Bucket with JPA annotations
 *  
 * @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
 */
@ApiModel(value = "Bucket", description = "A Bucket for categorizing Questions")

@Entity
@Table(name = "bucket")
public class Bucket implements Serializable {

	private static final long serialVersionUID = 2435095816452768808L;
	
	@ApiModelProperty(value = "id of the Bucket")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUCKET_SEQUENCE")
	@SequenceGenerator(name = "BUCKET_SEQUENCE", sequenceName = "BUCKET_SEQUENCE")
	@Column(name = "BUCKET_ID")
	private Integer bucketId;

	@ApiModelProperty(value = "Gets a Bucket by category")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQUENCE")
	@SequenceGenerator(name = "CATEGORY_SEQUENCE", sequenceName = "CATEGORY_SEQUENCE")
	@Column(name = "CATEGORY_ID")
	private Integer bucketCategory;

	@ApiModelProperty(value = "description of the Bucket")
	@Column(name = "BUCKET_DESCRIPTION")
	private String bucketDescription;

	@ApiModelProperty(value = "denotes whether Bucket is active or not")
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	
	@ApiModelProperty(value = "id of Skill Type")
	@Column(name ="Skill_Type_Id")
	private Integer skillTypeId;

	/**
	 * Constructs a bucket
	 * 
	 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 */
	public Bucket() {
		super();
	}

	/**
	 * Constructs a bucket
	 * 
	 * @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 * 
	 * @param bucketId - the Bucket id
	 * @param bucketCategory - the Bucket category
	 * @param bucketDescription - the Bucket's content description
	 * @param isActive true if active; false otherwise
	 */
	public Bucket(Integer bucketId, Integer bucketCategory, String bucketDescription, Boolean isActive, Integer skillTypeId) {
		super();
		this.bucketId = bucketId;
		this.bucketCategory = bucketCategory;
		this.bucketDescription = bucketDescription;
		this.isActive = isActive;
		this.skillTypeId = skillTypeId;
	}
	/**
	 * Gets a Bucket by id
	 * 
	 * @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 * 
	 * @return the Bucket id
	 */
	public Integer getBucketId() {
		return bucketId;
	}

	/**
	 * Sets the Bucket's id
	 * 
	 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 * 
	 * @param bucketId - the Bucket id to set
	 */
	public void setBucketId(Integer bucketId) {
		this.bucketId = bucketId;
	}

	/**
	 * Gets the Bucket's category
	 * 
	 * @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 * 
	 * @return the Bucket's category
	 */
	public Integer getBucketCategory() {
		return bucketCategory;
	}

	/** 
	 * Sets the Bucket's category
	 * 
	 * @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 * 
	 * @param bucketCategory - the Bucket's category to set
	 */
	public void setBucketCategory(Integer bucketCategory) {
		this.bucketCategory = bucketCategory;
	}

	/**
	 * Gets the Bucket's content description
	 * 
	 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 * 
	 * @return the ucket's content description
	 */
	public String getBucketDescription() {
		return bucketDescription;
	}

	/**
	 * Sets the Bucket's content description
	 * 
	 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 * 
	 * @param bucketDescription - the content description to set
	 */
	public void setBucketDescription(String bucketDescription) {
		this.bucketDescription = bucketDescription;
	}

	/**
	 * Gets the Bucket's active state
	 * 
	 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 * 
	 * @return true if active; false if not active
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * Sets the Bucket's active state
	 * 
	 * @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 * 
	 * @param isActive - true for active; false for inactive
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Gets the Skill Type Id number
	 * 
	 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 * 
	 * @return the Skill Type Id
	 */
	public int getSkillTypeId() {
		return skillTypeId;
	}

	/**
	 * Gets the Skill Type Id number
	 * 
	 *  @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
	 * 
	 * @param skillTypeId - the Skill Type's Id number
	 */
	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bucketCategory == null) ? 0 : bucketCategory.hashCode());
		result = prime * result + ((bucketDescription == null) ? 0 : bucketDescription.hashCode());
		result = prime * result + ((bucketId == null) ? 0 : bucketId.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((skillTypeId == null) ? 0 : skillTypeId.hashCode());
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
		if (bucketCategory == null) {
			if (other.bucketCategory != null)
				return false;
		} else if (!bucketCategory.equals(other.bucketCategory))
			return false;
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
		if (skillTypeId == null) {
			if (other.skillTypeId != null)
				return false;
		} else if (!skillTypeId.equals(other.skillTypeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bucket [bucketId=" + bucketId + ", bucketCategory=" + bucketCategory + ", bucketDescription="
				+ bucketDescription + ", isActive=" + isActive +", skillTypeId=" + skillTypeId + "]";
	}
}
