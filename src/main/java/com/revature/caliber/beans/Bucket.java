package com.revature.caliber.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import org.springframework.data.annotation.Id;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Bucket with JPA annotations
 *  
 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
 */
@ApiModel(value = "Bucket", description = "A Bucket for categorizing Questions")
//@Component
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

	@ApiModelProperty(value = "name of the Bucket's category")
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
	 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
	 */
	public Bucket() {
		super();
	}

	/**
	 * Constructs a bucket
	 * 
	 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
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
	 * Constructs a Bucket
	 * 
	 * @author Philip Escobeddo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param bucketCategory - the bucket category
	 * @param bucketDescription - the bucket's content description
	 * @param isActive - true if active; false otherwise
	 */
	/*
	public Bucket(Integer bucketCategory, String bucketDescription, Boolean isActive) {
		super();
		this.bucketCategory = bucketCategory;
		this.bucketDescription = bucketDescription;
		this.isActive = isActive;
	}
	*/
	/**
	 * Gets a Bucket by id
	 * 
	 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @return the Bucket id
	 */
	public Integer getBucketId() {
		return bucketId;
	}

	/**
	 * Sets the Bucket's id
	 * 
	 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param bucketId - the Bucket id to set
	 */
	public void setBucketId(Integer bucketId) {
		this.bucketId = bucketId;
	}

	/**
	 * Gets the Bucket's category
	 * 
	 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @return the Bucket's category
	 */
	public Integer getBucketCategory() {
		return bucketCategory;
	}

	/** 
	 * Sets the Bucket's category
	 * 
	 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param bucketCategory - the Bucket's category to set
	 */
	public void setBucketCategory(Integer bucketCategory) {
		this.bucketCategory = bucketCategory;
	}

	/**
	 * Gets the Bucket's content description
	 * 
	 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @return the ucket's content description
	 */
	public String getBucketDescription() {
		return bucketDescription;
	}

	/**
	 * Sets the Bucket's content description
	 * 
	 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param bucketDescription - the content description to set
	 */
	public void setBucketDescription(String bucketDescription) {
		this.bucketDescription = bucketDescription;
	}

	/**
	 * Gets the Bucket's active state
	 * 
	 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @return true if active; false if not active
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * Sets the Bucket's active state
	 * 
	 * @author Philip Escobedo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param isActive - true for active; false for inactive
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Gets the Skill Type Id number
	 * 
	 * @author Theodis Thompson |1805-May29-Java
	 * 
	 * @return the Skill Type Id
	 */
	public int getSkillTypeId() {
		return skillTypeId;
	}

	/**
	 * 
	 * @author TheodisThompson
	 * @param skillTypeId - the Skill Type's Id number
	 */
	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	@Override
	public String toString() {
		return "QuestionBucket [bucketId=" + bucketId + ", bucketCategory=" + bucketCategory + ", bucketDescription="
				+ bucketDescription + ", isActive=" + isActive +", skillTypeId=" + skillTypeId + "]";
	}
}
