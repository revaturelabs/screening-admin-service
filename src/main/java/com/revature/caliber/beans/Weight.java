package com.revature.caliber.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 
 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
 * 
 * POJO for the weight object
 *
 */
@ApiModel(value = "Weight", description = "Weights for Buckets within a SkillType, determining how a Bucket contributes to the final score")
@Entity
@Table(name = "weight")
public class Weight {
	
	@ApiModelProperty(value = "The weightId - primary key for the table")
	@Id
	@Column(name= "weight_id")
	private long weightId;
	
	@ApiModelProperty(value = "The actual weight needed for calculation")
	@Column(name = "weight")
	private int weight;
	
	@ApiModelProperty(value="the SkillType Id")
	@Column(name="skill_type_id")
	private int skillTypeId;
	
	@ApiModelProperty(value="The Bucket Id")
	@Column(name = "bucket_id")
	private int bucketId;

	public Weight() {
		super();
	}

	public Weight(int weightId, int weight, int skillTypeId, int bucketId) {
		super();
		this.weightId = weightId;
		this.weight = weight;
		this.skillTypeId = skillTypeId;
		this.bucketId = bucketId;
	}

	/**
	 * Getters and setters
	 */
	public long getWeightId() {
		return weightId;
	}

	public void setWeightId(long weightId) {
		this.weightId = weightId;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	public int getBucketId() {
		return bucketId;
	}

	public void setBucketId(int bucketId) {
		this.bucketId = bucketId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Weight [weightId=");
		builder.append(weightId);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", skillTypeId=");
		builder.append(skillTypeId);
		builder.append(", bucketId=");
		builder.append(bucketId);
		builder.append("]");
		return builder.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bucketId;
		result = prime * result + skillTypeId;
		result = prime * result + weight;
		result = prime * result + (int) (weightId ^ (weightId >>> 32));
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
		Weight other = (Weight) obj;
		if (bucketId != other.bucketId)
			return false;
		if (skillTypeId != other.skillTypeId)
			return false;
		if (weight != other.weight)
			return false;
		if (weightId != other.weightId)
			return false;
		return true;
	}
}
